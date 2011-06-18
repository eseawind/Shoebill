/**
 * Copyright (C) 2011 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#pragma comment (lib, "jvm.lib")
#pragma comment (lib, "jawt.lib")

#include <jni.h>
#include <stdio.h>
#include <string.h>
#include <io.h>

#include "jni_core.h"


JavaVM *jvm = NULL;
JNIEnv *env = NULL;


int jni_jvm_create( const char* classpath )
{
	JavaVMInitArgs vm_args;
	JavaVMOption options[3];

	if( jvm != NULL ) return -1;


	char clspath[2048] = "-Djava.class.path=";
	char jarpath[512];

	strcpy( jarpath, classpath );
	for( int i=strlen(jarpath)-1; i>=0; i-- )
		if( jarpath[i] == '/' ) { jarpath[i+1] = 0; break; }

	_finddata_t finddata;
	int hfind = _findfirst(classpath, &finddata);
	if( hfind < 0 ) return -2;

	do 
	{
		strcat( clspath, jarpath );
		strcat( clspath, finddata.name );
		strcat( clspath, ";" );
	} while ( !_findnext(hfind, &finddata) );
	_findclose( hfind );

	clspath[ strlen(clspath)-1 ] = 0;
	
	
	options[0].optionString = clspath;
	options[1].optionString = "-Djava.compiler=NONE";
	options[2].optionString = "-verbose:gc";

	//options[3].optionString = "vfprintf";
	//options[3].extraInfo = vfprintf;

	vm_args.version = JNI_VERSION_1_6;
	vm_args.options = options;
	vm_args.nOptions = sizeof(options) / sizeof(JavaVMOption);
	vm_args.ignoreUnrecognized = JNI_TRUE;

	jint res = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);
	if (res < 0) return -3;

	return 0;
}

int jni_jvm_newobject( jclass jcls, jobject *pjobj )
{
	jmethodID jmid;

	if( !jvm ) return -1;

	jmid = env->GetMethodID(jcls, "<init>", "()V");
	if( !jmid ) return -2;

	*pjobj = env->NewObject( jcls, jmid );
	if( !*pjobj ) return -3;

	return 0;
}

int jni_jvm_destroy()
{
	if( !jvm ) return -1;

	if ( env->ExceptionOccurred() ) env->ExceptionDescribe();
	jvm->DestroyJavaVM();

	env = NULL;
	jvm = NULL;
	return 0;
}
/*  SA-MP Functions
 *
 *  (c) Copyright 2005-2010, SA-MP Team
 *
 */


//----------------------------------------------------------
// a_samp.inc defines 

// Limits and internal constants
#define MAX_PLAYER_NAME							(24)
#define MAX_PLAYERS								(500)
#define MAX_VEHICLES							(2000)
#define INVALID_PLAYER_ID						(0xFFFF)
#define INVALID_VEHICLE_ID						(0xFFFF)
#define NO_TEAM									(255)
#define MAX_OBJECTS								(400)
#define INVALID_OBJECT_ID						(0xFFFF)
#define MAX_GANG_ZONES							(1024)
#define MAX_TEXT_DRAWS							(2048)
#define MAX_MENUS								(128)
#define MAX_3DTEXT_GLOBAL						(1024)
#define MAX_3DTEXT_PLAYER						(1024)
#define MAX_PICKUPS								(2048)
#define INVALID_MENU							(0xFF)
#define INVALID_TEXT_DRAW						(0xFFFF)
#define INVALID_GANG_ZONE						(-1)
#define INVALID_3DTEXT_ID						(0xFFFF)

// Player GUI Dialog
#define DIALOG_STYLE_MSGBOX		0
#define DIALOG_STYLE_INPUT		1
#define DIALOG_STYLE_LIST		2

// States
#define PLAYER_STATE_NONE						(0)
#define PLAYER_STATE_ONFOOT						(1)
#define PLAYER_STATE_DRIVER						(2)
#define PLAYER_STATE_PASSENGER					(3)
#define PLAYER_STATE_EXIT_VEHICLE				(4) // (used internally)
#define PLAYER_STATE_ENTER_VEHICLE_DRIVER		(5) // (used internally)
#define PLAYER_STATE_ENTER_VEHICLE_PASSENGER	(6) // (used internally)
#define PLAYER_STATE_WASTED						(7)
#define PLAYER_STATE_SPAWNED					(8)
#define PLAYER_STATE_SPECTATING					(9)

// Marker modes used by ShowPlayerMarkers()
#define PLAYER_MARKERS_MODE_OFF			(0)
#define PLAYER_MARKERS_MODE_GLOBAL		(1)
#define PLAYER_MARKERS_MODE_STREAMED	(2)

// Weapons
#define WEAPON_BRASSKNUCKLE				(1)
#define WEAPON_GOLFCLUB					(2)
#define WEAPON_NITESTICK				(3)
#define WEAPON_KNIFE					(4)
#define WEAPON_BAT						(5)
#define WEAPON_SHOVEL					(6)
#define WEAPON_POOLSTICK				(7)
#define WEAPON_KATANA					(8)
#define WEAPON_CHAINSAW					(9)
#define WEAPON_DILDO					(10)
#define WEAPON_DILDO2					(11)
#define WEAPON_VIBRATOR					(12)
#define WEAPON_VIBRATOR2				(13)
#define WEAPON_FLOWER					(14)
#define WEAPON_CANE						(15)
#define WEAPON_GRENADE					(16)
#define WEAPON_TEARGAS					(17)
#define WEAPON_MOLTOV					(18)
#define WEAPON_COLT45					(22)
#define WEAPON_SILENCED					(23)
#define WEAPON_DEAGLE					(24)
#define WEAPON_SHOTGUN					(25)
#define WEAPON_SAWEDOFF					(26)
#define WEAPON_SHOTGSPA					(27)
#define WEAPON_UZI						(28)
#define WEAPON_MP5						(29)
#define WEAPON_AK47						(30)
#define WEAPON_M4						(31)
#define WEAPON_TEC9						(32)
#define WEAPON_RIFLE					(33)
#define WEAPON_SNIPER					(34)
#define WEAPON_ROCKETLAUNCHER			(35)
#define WEAPON_HEATSEEKER				(36)
#define WEAPON_FLAMETHROWER				(37)
#define WEAPON_MINIGUN					(38)
#define WEAPON_SATCHEL					(39)
#define WEAPON_BOMB						(40)
#define WEAPON_SPRAYCAN					(41)
#define WEAPON_FIREEXTINGUISHER			(42)
#define WEAPON_CAMERA					(43)
#define WEAPON_PARACHUTE				(46)
#define WEAPON_VEHICLE					(49)
#define WEAPON_DROWN					(53)
#define WEAPON_COLLISION				(54)

// Keys
#define KEY_ACTION				(1)
#define KEY_CROUCH				(2)
#define KEY_FIRE				(4)
#define KEY_SPRINT				(8)
#define KEY_SECONDARY_ATTACK	(16)
#define KEY_JUMP				(32)
#define KEY_LOOK_RIGHT			(64)
#define KEY_HANDBRAKE			(128)
#define KEY_LOOK_LEFT			(256)
#define KEY_SUBMISSION			(512)
#define KEY_LOOK_BEHIND			(512)
#define KEY_WALK				(1024)
#define KEY_ANALOG_UP			(2048)
#define KEY_ANALOG_DOWN			(4096)
#define KEY_ANALOG_LEFT			(8192)
#define KEY_ANALOG_RIGHT		(16384)

#define KEY_UP					(-128)
#define KEY_DOWN				(128)
#define KEY_LEFT				(-128)
#define KEY_RIGHT				(128)


#define CLICK_SOURCE_SCOREBOARD		0


//----------------------------------------------------------
// a_players.inc defines


#define SPECIAL_ACTION_NONE				0
#define SPECIAL_ACTION_DUCK				1
#define SPECIAL_ACTION_USEJETPACK		2
#define SPECIAL_ACTION_ENTER_VEHICLE	3
#define SPECIAL_ACTION_EXIT_VEHICLE     4
#define SPECIAL_ACTION_DANCE1			5
#define SPECIAL_ACTION_DANCE2			6
#define SPECIAL_ACTION_DANCE3			7
#define SPECIAL_ACTION_DANCE4			8
#define SPECIAL_ACTION_HANDSUP			10
#define SPECIAL_ACTION_USECELLPHONE		11
#define SPECIAL_ACTION_SITTING			12
#define SPECIAL_ACTION_STOPUSECELLPHONE 13
#define SPECIAL_ACTION_DRINK_BEER		20
#define SPECIAL_ACTION_SMOKE_CIGGY		21
#define SPECIAL_ACTION_DRINK_WINE		22
#define SPECIAL_ACTION_DRINK_SPRUNK		23

#define FIGHT_STYLE_NORMAL				4
#define FIGHT_STYLE_BOXING				5
#define FIGHT_STYLE_KUNGFU				6
#define FIGHT_STYLE_KNEEHEAD			7
#define FIGHT_STYLE_GRABKICK			15
#define FIGHT_STYLE_ELBOW				16

#define WEAPONSKILL_PISTOL 				0
#define WEAPONSKILL_PISTOL_SILENCED		1
#define WEAPONSKILL_DESERT_EAGLE		2
#define WEAPONSKILL_SHOTGUN				3
#define WEAPONSKILL_SAWNOFF_SHOTGUN		4
#define WEAPONSKILL_SPAS12_SHOTGUN		5
#define WEAPONSKILL_MICRO_UZI			6
#define WEAPONSKILL_MP5					7
#define WEAPONSKILL_AK47				8
#define WEAPONSKILL_M4					9
#define WEAPONSKILL_SNIPERRIFLE			10

#define WEAPONSTATE_UNKNOWN				-1
#define WEAPONSTATE_NO_BULLETS			0
#define WEAPONSTATE_LAST_BULLET			1
#define WEAPONSTATE_MORE_BULLETS		2
#define WEAPONSTATE_RELOADING			3

#define MAX_PLAYER_ATTACHED_OBJECTS		5 // This is the number of attached indexes 

#define MAX_CHATBUBBLE_LENGTH		144

#define MAPICON_LOCAL			  0 // displays in the player's local are
#define MAPICON_GLOBAL			  1 // displays always
#define MAPICON_LOCAL_CHECKPOINT  2 // displays in the player's local area and has a checkpoint marker
#define MAPICON_GLOBAL_CHECKPOINT 3 // displays always and has a checkpoint marker

// Spectating
#define SPECTATE_MODE_NORMAL	1
#define SPECTATE_MODE_FIXED		2
#define SPECTATE_MODE_SIDE		3

// Recording for NPC playback
#define PLAYER_RECORDING_TYPE_NONE		0
#define PLAYER_RECORDING_TYPE_DRIVER	1
#define PLAYER_RECORDING_TYPE_ONFOOT	2


//----------------------------------------------------------
// a_vehicles.inc defines

#define CARMODTYPE_SPOILER		0
#define CARMODTYPE_HOOD			1
#define CARMODTYPE_ROOF			2
#define CARMODTYPE_SIDESKIRT	3
#define CARMODTYPE_LAMPS		4
#define CARMODTYPE_NITRO		5
#define CARMODTYPE_EXHAUST		6
#define CARMODTYPE_WHEELS		7
#define CARMODTYPE_STEREO		8
#define CARMODTYPE_HYDRAULICS	9
#define CARMODTYPE_FRONT_BUMPER	10
#define CARMODTYPE_REAR_BUMPER	11
#define CARMODTYPE_VENT_RIGHT	12
#define CARMODTYPE_VENT_LEFT	13

#define VEHICLE_PARAMS_UNSET	-1
#define VEHICLE_PARAMS_OFF		0
#define VEHICLE_PARAMS_ON		1


//----------------------------------------------------------
// Callbacks & Functions

#include "callback.h"
#include "function.h"
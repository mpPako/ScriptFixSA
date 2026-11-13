MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***********************************    Casino 7   ***************************************
// ********************************* Clear & Present Danger ********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME CASINO7

// Mission start stuff

GOSUB mission_start_mafia1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_mafia1_failed
ENDIF

GOSUB mission_cleanup_mafia1

MISSION_END

{ 
// Variables for mission



// **************************************** Mission Start **********************************

mission_start_mafia1:

LOAD_MISSION_TEXT CASINO7

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

WAIT 0

SET_AREA_VISIBLE 11

LOAD_CUTSCENE CAS_7b
 
WHILE NOT HAS_CUTSCENE_LOADED
	WAIT 0
ENDWHILE
 
START_CUTSCENE

DO_FADE 1000 FADE_IN
  
WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE
 
SET_PLAYER_CONTROL player1 OFF

DO_FADE 0 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

SET_AREA_VISIBLE 0



// ****************************************START OF CUTSCENE********************************


// ****************************************END OF CUTSCENE**********************************

// fades the screen in 


SET_FADING_COLOUR 0 0 0

SET_CHAR_HAS_USED_ENTRY_EXIT scplayer 2016.4222 1017.1024 10.0 //TRIAD CASINO
REQUEST_COLLISION 2025.80 1007.87 
LOAD_SCENE_IN_DIRECTION 2025.80 1007.87 9.81 279.83

SET_CHAR_COORDINATES scplayer 2025.80 1007.87 9.81   
SET_CHAR_HEADING scplayer 279.83

// PakoChange: Added asset pickup to 4dragons
//cutscene for 4dragons
CREATE_PROTECTION_PICKUP 2024.8570 1018.8700 10.3358 fourdragons_revenue fourdragons_revenue fourdragons_cash_pickup

SWITCH_WIDESCREEN ON

LOAD_SCENE 2036.8410 1006.7530 13.3812
SET_FIXED_CAMERA_POSITION 2036.8410 1006.7530 11.3812 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 2034.9080 1007.3170 11.8427 JUMP_CUT
DO_FADE 2000 FADE_IN
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PLAY_MISSION_PASSED_TUNE 1
PRINT_BIG ASS_ACQ 5000 6

WAIT 5000
SET_FIXED_CAMERA_POSITION 2028.7380 1021.1080 10.8203 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 2024.2340 1016.2300 11.3002 JUMP_CUT
PRINT_WITH_NUMBER_NOW ASS_LUV fourdragons_revenue 6000 1

WAIT 6000
DO_FADE 500 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON

DO_FADE 2000 FADE_IN
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

GOTO mission_mafia1_passed

mission_mafia1_failed:
	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission mafia1 passed ************************

mission_mafia1_passed:

	REMOVE_BLIP casino_contact_blip
	flag_casino_mission_counter ++
	REGISTER_MISSION_PASSED ( CASINO7 )
	//PRINT_WITH_NUMBER_BIG ( M_PASS ) 200 5000 1 //"Mission Passed!"
	//ADD_SCORE player1 200
	SET_INT_STAT PASSED_CASINO7 1
	CLEAR_WANTED_LEVEL player1
	PLAYER_MADE_PROGRESS 1
	
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_mafia1:

	flag_player_on_mission = 0
	GET_GAME_TIMER timer_mobile_start

MISSION_HAS_FINISHED
RETURN

 
}


package triviaMaze_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import triviaMaze.Door;
import triviaMaze.DoorStatus;
import triviaMaze.ID;

class Door_tests {

	@Test
	void Doortest_getStatus_Init() 
	{
		Door testDoor = new Door(0, 0, ID.DoorVertical, null, DoorStatus.Init);
		assertTrue(testDoor.getDoorStatus() == DoorStatus.Init);
	}
	
	@Test
	void Doortest_getStatus_Locked() 
	{
		Door testDoor = new Door(0, 0, ID.DoorVertical, null, DoorStatus.Locked);
		assertTrue(testDoor.getDoorStatus() == DoorStatus.Locked);
	}
	
	@Test
	void Doortest_getStatus_Passed() 
	{
		Door testDoor = new Door(0, 0, ID.DoorVertical, null, DoorStatus.Passed);
		assertTrue(testDoor.getDoorStatus() == DoorStatus.Passed);
	}
	
	@Test
	void Doortest_getStatus_Locked_False() 
	{
		Door testDoor = new Door(0, 0, ID.DoorVertical, null, DoorStatus.Passed);
		assertFalse(testDoor.getDoorStatus() == DoorStatus.Locked);
	}
	
	@Test
	void Doortest_getStatus_Passed_False() 
	{
		Door testDoor = new Door(0, 0, ID.DoorVertical, null, DoorStatus.Locked);
		assertFalse(testDoor.getDoorStatus() == DoorStatus.Passed);
	}

}
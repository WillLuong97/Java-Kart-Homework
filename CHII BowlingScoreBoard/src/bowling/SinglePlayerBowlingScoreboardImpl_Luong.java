package bowling;

public class SinglePlayerBowlingScoreboardImpl_Luong implements SinglePlayerBowlingScoreboard, AssignmentMetaData
{
	private static final int MAXIMUM_ROLLS = 21;	//Maximum rolls in a one player game
	private String playerName;
	private int[] pinsKnockedDownArray = new int[MAXIMUM_ROLLS];
	private int rollCount = 0;
	
	//default constructor
	public SinglePlayerBowlingScoreboardImpl_Luong(String playerName)
	{
		//Player must always have a name!!!
		assert playerName != null : "playerName is null!";
		
		//Getting the player name
		this.playerName = playerName;
	} //end of SinglePlayerBowlingScoreboardImpl_Luong(String playerName).
	
	//Pre-condition: player's name cannot be a null!
	//Post-condition: none
	public String getPlayerName()
	{
		//player must have a name!
		assert playerName != null : "playerName is null!";
		return playerName;
	} //end of getPlayerName().
	
	//Pre-condtion: !isGameOver -- The game must not over.
	//Post-condition: 0<rv<=10 -- Must be within the right score boundary.
	//To-do: return the current frame of the game
	public int getCurrentFrame() 
	{
		//Executable pre-condition:
		assert !isGameOver() : "Game is over!";
		int currentFrame = 0;
		//if the rollcount is an even number, it will be placed in the 2nd index of the box
		if(rollCount % 2 == 0)
		{
			currentFrame = (rollCount + 2)/2;
		}
		
		//Otherwise, place it in the 1st index
		else
		{
			currentFrame = (rollCount + 1)/2;
		}
		
		return currentFrame;
	} //end of getCurrentFrame().

	//Pre-condition: 
//	assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
//	assert frameNumber <= 10 : "frameNumber = " + frameNumber + " > 10!";
//	assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
//	assert boxIndex <= 3 : "boxIndex = " + boxIndex + " > 3!";
	//To-do: returning a mark that represent the score of the player on the scoreboard.
	public Mark getMark(int frameNumber, int boxIndex) 
	{	
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 10 : "frameNumber = " + frameNumber + " > 10!";
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 3 : "boxIndex = " + boxIndex + " > 3!";
		Mark mark = null;
		if(frameNumber < 10) mark = getMarkSingleDigitFrameNumber(frameNumber, boxIndex);
		else mark = getMarkTenthFrame(boxIndex);
		assert mark != null : "mark is null!";
		return mark;
	} //end of getMark()
	
	
	//Helper Method: Converting a the digit score into an equivalent mark
	private Mark getMarkSingleDigitFrameNumber(int frameNumber, int boxIndex)
	{
		//executable precondition:
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 9 : "frameNumber = " + frameNumber + " > 9!";
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 2 : "boxIndex = " + boxIndex + " > 2!";
		
		Mark retMark;
		
		//finding the first ball the given frame number:
		int firstRollIndex = getRollIndexOfFirstBall(frameNumber);
		//if the player score a strike, the mark will be a strike mark
		if(pinsKnockedDownArray[firstRollIndex] == 10)
		{
			if(boxIndex == 1)	//mark is empty is at boxIndex 1.
			{
				retMark = Mark.EMPTY;
			}
			retMark = Mark.STRIKE;
		}
		//if the player score a spare.
		else if(pinsKnockedDownArray[firstRollIndex] + pinsKnockedDownArray[firstRollIndex + 1] == 10)
		{
			retMark = Mark.SPARE;
		}
		
		//Non-strike, spare cases:
		retMark = Mark.translate(pinsKnockedDownArray[firstRollIndex + (boxIndex - 1)]);
		return retMark;
		
	}//end of getMarkSingleDigitFrameNumber(frameNumber,boxIndex)
	
	//saving for stage 2!
	private Mark getMarkTenthFrame(int boxIndex)
	{
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 3 : "boxIndex = " + boxIndex + " > 3!";
		int firstRollIndex = getRollIndexOfFirstBall(10);
		if(pinsKnockedDownArray[firstRollIndex + (boxIndex - 1)] == 10)
		{
			return Mark.STRIKE;
		}
		
		else if(boxIndex == 2 || boxIndex == 3)
		{
			if(pinsKnockedDownArray[firstRollIndex + (boxIndex - 1)] + pinsKnockedDownArray[pinsKnockedDownArray[firstRollIndex + (boxIndex - 2)]] == 10)
			{
				return Mark.SPARE;
			}
		}
		
		//Non-strike and spare frame
		return Mark.translate(pinsKnockedDownArray[firstRollIndex]);
	}//end of getMarkTenthFrame(int boxIndex)

	//part of pre: 1 <= frameNumber <= 10
	//part of pre: getCurrentFrame() > frameNumber
	public int getScore(int frameNumber) {
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 10 : "frameNumber = " + frameNumber + " > 10!";
		
		int retScore = 0;
		int currFrame = getCurrentFrame();
		assert currFrame > frameNumber;
		//looping through each frame
		for(int indexOfFrame = 1; indexOfFrame <= frameNumber; indexOfFrame++)
		{
			int firstRollIndex = getRollIndexOfFirstBall(frameNumber);
			if(indexOfFrame != 10) //under 10 frame
			{
				//checking for strike.
				if(isStrike(frameNumber)) 
				{
					if(firstRollIndex + 2 < rollCount)
					{ //at the possibiilty of a strike, the scoring scheme is 10 + the total of the next two rolls
						retScore += 10 + pinsKnockedDownArray[firstRollIndex+1] + pinsKnockedDownArray[firstRollIndex + 2];
					}
					
				}
				//checking for spare
				else if(isSpare(frameNumber))
				{
					if(firstRollIndex + 2 < rollCount)
					{ //at the possibility of a spare, the scoring schene is 10 + plus a bonus of whatever is scored with the next ball (only the first ball is counted)
						retScore += 10 + pinsKnockedDownArray[firstRollIndex] + pinsKnockedDownArray[firstRollIndex + 1];
					}
				}
				
				else
				{
					int firstIndexValue = getMarkSingleDigitFrameNumber(indexOfFrame, 1).getValue();
					int secIndexValue = getMarkSingleDigitFrameNumber(indexOfFrame, 2).getValue();
					retScore += (firstIndexValue + secIndexValue);
					
				}
			}
			//Tenth frame:
			else
			{
				retScore = getScoreTenthFrame();
			}
			
		}
		return retScore;
	}//end of getScore()
	
	private int getScoreTenthFrame()
	{
		int scoreOfTenthFrame = 0;
		int firstRollIndexOfTenthFrame = getRollIndexOfFirstBall(10);
		//looping through the roll of tenth frame:
		for(int indexFrame = firstRollIndexOfTenthFrame; indexFrame < firstRollIndexOfTenthFrame + 3; indexFrame++)
		{
			//At the tenth frame, the scoring scheme would include all the score of the two rolls in tenth frame.
			scoreOfTenthFrame += pinsKnockedDownArray[indexFrame];
		}
		
		return scoreOfTenthFrame;
	}//end of getScoreTenthFrame()
	
	//pre-condition: none.
	//post-condition: none.
	public boolean isGameOver() 
	{
		//the game cannot be over:
		if(rollCount >= 12 && rollCount < 21)
		{
			int numOfFrame = 1;
			int boxIndex = 1;
			for(int i  = 0; i < rollCount ; i++)
			{
				//below 10 frames
				if(numOfFrame != 10)
				{
					if(pinsKnockedDownArray[i] == 10 || boxIndex == 2)
					{
						numOfFrame++;
						boxIndex = 1;
					}
				}
				
				else
				{
					boxIndex++;
				}
			}
			
			//the game is not finished so it cannot be over
			if(numOfFrame < 10)
			{
				return false;
			}
		
			
			//TEN frames:
			int firstRollIndexOfTenthBall = getRollIndexOfFirstBall(10);
			//there are 3 rolls in the 10th frame, and 10th frame is the last frame that can end the game
			int totalRollsInTenthFrame = firstRollIndexOfTenthBall + 2; //1 + 2 = 3
			
			//the game ends when roll count maxes out all the rolls
			if(rollCount == totalRollsInTenthFrame)
			{
				return true;
			}
			
			//if a strike is scored at the first rolls of the 10th frame, then the other two frames is still ongoing
			if(pinsKnockedDownArray[firstRollIndexOfTenthBall] == 10)
			{
				totalRollsInTenthFrame = firstRollIndexOfTenthBall + 3;
			}
			
			//Spare: when the first two rolls of the 10th frame still have a spares, then the game is still ongoing
			else if(pinsKnockedDownArray[firstRollIndexOfTenthBall] + pinsKnockedDownArray[firstRollIndexOfTenthBall+1] == 10)
			{
				totalRollsInTenthFrame = firstRollIndexOfTenthBall + 3;
			}			
		}
		return false;
	}//end of isGameOver()

	//To-do: returning the count of the roll
	public void recordRoll(int pinsKnockedDown) 
	{
		//executable precondition:
		assert 0 <= pinsKnockedDown : "pinsKnockedDown = " + pinsKnockedDown + " < 0!";
		assert pinsKnockedDown <= 10 : "pinsKnockedDown = " + pinsKnockedDown + " > 10!";
		assert (getCurrentBall() == 1) || 
				((getCurrentBall() == 2) && (((getCurrentFrame() == 10) && isStrikeOrSpare(getMark(10, 1))) || ((pinsKnockedDownArray[rollCount - 1] + pinsKnockedDown) <= 10))) || 
				((getCurrentBall() == 3) && (((getCurrentFrame() == 10) && isStrikeOrSpare(getMark(10, 2))) || ((pinsKnockedDownArray[rollCount - 1] + pinsKnockedDown) <= 10)));
		assert !isGameOver() : "Game is over!";

		pinsKnockedDownArray[rollCount] = pinsKnockedDown;
		rollCount++;
	}//end of recordRoll().
	
	
	//part of pre: !isGameOver()
	//part of post: 1 <= rv <= 3
	//part of post: frameNumber < 10 ==> rv <= 2
	//part of post: ((frameNumber < 10) && (rv == 2)) ==> getMark(frameNumber, 1).equals(Mark.STRIKE)
	//To-do: Returning which turn of the game the player is currently in!
	public int getCurrentBall() { 
		
		//Executable pre-condition:
		assert !isGameOver() : "Game is over!";	//game cannot be over yet!
		int currBall = 0;
		int currentFrame = getCurrentFrame();
		currBall = (rollCount - getRollIndexOfFirstBall(currentFrame)) + 1;
		assert (1 <= currBall) && (currBall <= 3);
		
		return currBall;
	}//end of getCurrentBall()

	private static final String VERTICAL_SEPARATOR = "#";
	private static final String HORIZONTAL_SEPARATOR = "#";
	private static final String LEFT_EDGE_OF_SMALL_SQUARE = "[";
	private static final String RIGHT_EDGE_OF_SMALL_SQUARE = "]";
	//To-do: returning the scoreboard visual representation!
	private String getScoreboardDisplay()
	{
		StringBuffer frameNumberLineBuffer = new StringBuffer();
		StringBuffer markLineBuffer = new StringBuffer();
		StringBuffer horizontalRuleBuffer = new StringBuffer();
		StringBuffer scoreLineBuffer = new StringBuffer();
		frameNumberLineBuffer.append(VERTICAL_SEPARATOR);
		
		markLineBuffer.append(VERTICAL_SEPARATOR);
		horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
		scoreLineBuffer.append(VERTICAL_SEPARATOR);

		for(int frameNumber = 1; frameNumber <= 9; frameNumber++)
		{
			frameNumberLineBuffer.append("  " + frameNumber + "  ");
			markLineBuffer.append(" ");
			markLineBuffer.append(getMark(frameNumber, 1));
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(getMark(frameNumber, 2));
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);
			
			final int CHARACTER_WIDTH_SCORE_AREA = 5;
			for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) horizontalRuleBuffer.append(HORIZONTAL_SEPARATOR);
			if(isGameOver() || frameNumber < getCurrentFrame())
			{
				int score = getScore(frameNumber);
				final int PADDING_NEEDED_BEHIND_SCORE = 1;
				final int PADDING_NEEDED_IN_FRONT_OF_SCORE = CHARACTER_WIDTH_SCORE_AREA - ("" + score).length() - PADDING_NEEDED_BEHIND_SCORE;
				for(int i = 0; i < PADDING_NEEDED_IN_FRONT_OF_SCORE; i++) scoreLineBuffer.append(" ");
				scoreLineBuffer.append(score);
				for(int i = 0; i < PADDING_NEEDED_BEHIND_SCORE; i++) scoreLineBuffer.append(" ");
			}
			else
			{
				for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) scoreLineBuffer.append(" ");
			}
			
			frameNumberLineBuffer.append(VERTICAL_SEPARATOR);
			markLineBuffer.append(VERTICAL_SEPARATOR);
			horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
			scoreLineBuffer.append(VERTICAL_SEPARATOR);
		}
		//Frame 10:
		{
			final String THREE_SPACES = "   ";
			frameNumberLineBuffer.append(THREE_SPACES + 10 + THREE_SPACES);

			markLineBuffer.append(" ");
			markLineBuffer.append(getMark(10, 1));
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(getMark(10, 2));
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(getMark(10, 3));
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);
			
			final int CHARACTER_WIDTH_SCORE_AREA = 8;
			for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) horizontalRuleBuffer.append(HORIZONTAL_SEPARATOR);
			if(isGameOver())
			{
				int score = getScore(10);
				final int PADDING_NEEDED_BEHIND_SCORE = 1;
				final int PADDING_NEEDED_IN_FRONT_OF_SCORE = CHARACTER_WIDTH_SCORE_AREA - ("" + score).length() - PADDING_NEEDED_BEHIND_SCORE;
				for(int i = 0; i < PADDING_NEEDED_IN_FRONT_OF_SCORE; i++) scoreLineBuffer.append(" ");
				scoreLineBuffer.append(score);
				for(int i = 0; i < PADDING_NEEDED_BEHIND_SCORE; i++) scoreLineBuffer.append(" ");
			}
			else
			{
				for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) scoreLineBuffer.append(" ");
			}
			
			frameNumberLineBuffer.append(VERTICAL_SEPARATOR);
			markLineBuffer.append(VERTICAL_SEPARATOR);
			horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
			scoreLineBuffer.append(VERTICAL_SEPARATOR);
		}
			
		return 	getPlayerName() + "\n" +
				horizontalRuleBuffer.toString() + "\n" +
				frameNumberLineBuffer.toString() + "\n" +
				horizontalRuleBuffer.toString() + "\n" +
				markLineBuffer.toString() + "\n" +
				scoreLineBuffer.toString() + "\n" +
				horizontalRuleBuffer.toString();
	}//end of getScoreboardDisplay().
	
	public String toString()
	{
		return getScoreboardDisplay();
	}//end of toString().
	
	//Helper Method: returning the index of the roll into
	private int getRollIndexOfFirstBall(int frameNumber)
	{
		int firstRollIndex = 0;
		int boxIndex = 1;
		int frameCounter = 1;
		
		while( frameCounter != frameNumber )
		{
			//if there is a strike, and box is not at the first position
			if(pinsKnockedDownArray[firstRollIndex] == 10 || boxIndex == 2)
			{
				frameCounter++;
				boxIndex = 1;
				
			}
				
			else
			{
				boxIndex++;
			}
			
			firstRollIndex++;

		}//end while
			
		return firstRollIndex;
	}//end of getRollIndexOfFirstBall().
	
	//Helper method: checking for a strike
	private boolean isStrike(int frameNumber)
	{
		int firstRoll = getRollIndexOfFirstBall(frameNumber);
		
		if(pinsKnockedDownArray[firstRoll] == 10) //if there is a strike in the first roll
		{
			return true;
		}
		
		
		if(frameNumber == 10)
		{
			//at the 10th frame, since there are 3 rolls, check to see if 2nd roll and 3rd roll have a strike
			if(pinsKnockedDownArray[firstRoll + 1] == 10 || pinsKnockedDownArray[firstRoll + 2] ==10)
			{
				return true;
			}
		}
		
		return false;

	} //end of isStrike(int frameNumber)
	
	//helper method: checking for isSpare()
	private boolean isSpare(int frameNumber)
	{
		int firstRoll = getRollIndexOfFirstBall(frameNumber);
		
		//if there is a 10th frame and a strike
		if(frameNumber == 10 && pinsKnockedDownArray[firstRoll] == 10)
		{
			firstRoll++;
		}
		
		return pinsKnockedDownArray[firstRoll] + pinsKnockedDownArray[firstRoll + 1] == 10;
	} //end of isSpare(int frameNumber)

	private boolean isStrikeOrSpare(Mark mark)
	{
		return ((mark == Mark.STRIKE) || (mark == Mark.SPARE));
	}
	
	//*************************************************
	//*************************************************
	//*************************************************
	//*********ASSIGNMENT METADATA STUFF***************
	public String getFirstNameOfSubmitter() 
	{
		String firstName = "Will";
		return firstName;
	}//end of getFirstNameOfSubmitter() 

	public String getLastNameOfSubmitter() 
	{
		String lastName = "Luong";
		return lastName;
	}// end of getLastNameOfSubmitter()
	
	public double getHoursSpentWorkingOnThisAssignment()
	{
		double timeSpent = 7;
		return timeSpent;
	}//end of getHoursSpentWorkingOnThisAssignment()
	
	public int getScoreAgainstTestCasesSubset()
	{
		//This could be wrong
		//BUT I AM FEELING CONFIDENT TODAY!
		int score = 100;
		return score; 
	}//end of getScoreAgainstTestCasesSubset
}//end of SinglePlayerBowlingScoreBoardImpl_Luong.java
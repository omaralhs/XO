package main;
import java.util.Scanner;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
public class game {
	public String [][] board=new String[3][3];
	public game() {
		buildTable(board);
	}

	public String[][] getboard() {
		return board;
	}

	public void setboard(String newb[][]) {
		board=newb;
	}



	public void buildTable(String[][]b) {
		int count=1;
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				b[i][j]=""+count;	
				count++;
			}
		}
	}

	public void playerTurn() {
		Scanner sc=new Scanner(System.in);
		System.out.println("set ur mark :");
		int place=sc.nextInt();
		while(checkBoard(place)) {
			System.out.println("you cant choose this place!!!. please choose another :");
			place=sc.nextInt();
		}


	}

	public void BotPlace(String place) {
		for(int i=0;i<board.length;i++) 
			for(int j=0;j<board[i].length;j++) 
				if(board[i][j]!="O"&&board[i][j]!="X")
					if(place.equals(board[i][j])) 
						board[i][j]="X";



	}
	public boolean isDRAW() {
		for(int i=0;i<board.length;i++) 
			for(int j=0;j<board[i].length;j++) 
				if(board[i][j]!="O"&&board[i][j]!="X")
					return false;
		return true;
	}


	public boolean checkBoard(int place) {

		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]!="O"&&board[i][j]!="X")
					if(place==Integer.parseInt(board[i][j])) {
						board[i][j]="X";
						return false;

					}
			}

		}

		return true;
	}
	public void printBoard(GuildMessageReactionAddEvent event) {
		event.getChannel().sendMessage(board[0][0]+" "+board[0][1]+" "+board[0][2]+"\n"+board[1][0]+" "+board[1][1]+" "+board[1][2]+"\n"+board[2][0]+" "+board[2][1]+" "+board[2][2]+" ").queue();


	}
	public void printBoard(GuildMessageReceivedEvent e) {
		e.getChannel().sendMessage(board[0][0]+" "+board[0][1]+" "+board[0][2]+"\n"+board[1][0]+" "+board[1][1]+" "+board[1][2]+"\n"+board[2][0]+" "+board[2][1]+" "+board[2][2]+" ").queue();


	}

	public  void addReactfunc(GuildMessageReceivedEvent e,String board[][]) {
		int count=1;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]!="O"&&board[i][j]!="X")
					e.getMessage().addReaction("U+003"+count+" U+FE0F U+20E3").queue();
				count++;
			}		

		}
		e.getMessage().addReaction("U+1F3F3").queue();

		
	}

	public boolean checkfinish() {
		for(int i=0;i<board.length;i++) {
			if(board[i][0]==board[i][1] && board[i][1]==board[i][2]&&board[i][2]==board[i][0])
				return true;
		}
		for(int i=0;i<board[0].length;i++) {
			if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[2][i]==board[0][i])
				return true;
		}
		if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]==board[0][0])
			return true;

		if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]==board[0][2])
			return true;

		return false;
	}


	public void BotTurn() {

		for(int i=0;i<board.length;i++) {
			int O=0;
			int countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[i][j]=="O")
					O++;
				if(board[i][j]!="X"&&board[i][j]!="O")
					countNull++;

			}
			if(O==2&&countNull==1)
				for(int k=0;k<3;k++)
					if(board[i][k]!="X"&&board[i][k]!="O") {
						board[i][k]="O";
						return;
					}
		}

		for(int i=0;i<board.length;i++) {
			int O=0;
			int countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[j][i]=="O")
					O++;
				if(board[j][i]!="X"&&board[j][i]!="O")
					countNull++;


			}
			if(O==2&&countNull==1)
				for(int k=0;k<3;k++)
					if(board[k][i]!="X"&&board[k][i]!="O") {
						board[k][i]="O";
						return;
					}
		}


		int O=0;
		int countNull=0;

		for(int i=0;i<3;i++) {
			if(board[i][i]=="O")
				O++;
			if(board[i][i]!="X"&&board[i][i]!="O")
				countNull++;
		}
		if(O==2&&countNull==1)
			for(int i=0;i<3;i++)
				if(board[i][i]!="X"&&board[i][i]!="O") {
					board[i][i]="O";
					return;
				}



		O=0;
		countNull=0;
		for(int k=2,i=0;i<3;i++,k--) {
			if(board[i][k]=="O")
				O++;
			if(board[i][i]!="X"&&board[i][i]!="O")
				countNull++;
		}
		if(O==2&&countNull==1)
			for(int k=2,i=0;i<3;i++,k--)
				if(board[i][k]!="X"&&board[i][k]!="O") {
					board[i][k]="O";
					return;
				}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



		for(int i=0;i<board.length;i++) {
			int x=0;
			countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[i][j]=="X")
					x++;
				if(board[i][j]!="X"&&board[i][j]!="O")
					countNull++;

			}
			if(x==2&&countNull==1)
				for(int k=0;k<3;k++)
					if(board[i][k]!="X"&&board[i][k]!="O") {
						board[i][k]="O";
						return;
					}
		}

		for(int i=0;i<board.length;i++) {
			int x=0;
			countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[j][i]=="X")
					x++;
				if(board[j][i]!="X"&&board[j][i]!="O")
					countNull++;


			}
			if(x==2&&countNull==1)
				for(int k=0;k<3;k++)
					if(board[k][i]!="X"&&board[k][i]!="O") {
						board[k][i]="O";
						return;
					}
		}


		int x=0;
		countNull=0;
		for(int i=0;i<3;i++) {
			if(board[i][i]=="X")
				x++;
			if(board[i][i]!="X"&&board[i][i]!="O")
				countNull++;
		}
		if(x==2&&countNull==1)
			for(int i=0;i<3;i++)
				if(board[i][i]!="X"&&board[i][i]!="O") {
					board[i][i]="O";
					return;
				}



		x=0;
		countNull=0;
		for(int k=2,i=0;i<3;i++,k--) {
			if(board[i][k]=="X")
				x++;
			if(board[i][k]!="X"&&board[i][k]!="O")             ///////////////////////////////////right to left half
				countNull++;
		}
		if(x==2&&countNull==1)
			for(int k=2,i=0;i<3;i++,k--)
				if(board[i][k]!="X"&&board[i][k]!="O") {
					board[i][k]="O";
					return;
				}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		if(board[1][1]!="X"&&board[1][1]!="O") {
			board[1][1]="O";
			return;
		}
		if(board[2][2]=="X"&&board[1][1]=="X"&&board[0][2]!="X"&&board[0][2]!="X") {
			board[0][2]="O";
			return;
		}


		if(board[2][1]=="X"&&board[1][2]=="X"&&board[2][2]!="O") {
			board[2][2]="O";
			return;
		}

		if(board[1][0]=="X"&&board[2][1]=="X"&&board[2][0]!="O") {
			board[2][0]="O";
			return;
		}

		if(board[0][1]=="X"&&board[1][2]=="X"&&board[0][2]!="O") {
			board[0][2]="O";
			return;
		}

		for(int i=0;i<board.length;i++) {
			O=0;
			countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[i][j]=="O")
					O++;
				if(board[i][j]!="X"&&board[i][j]!="O")
					countNull++;

			}
			if(O==1&&countNull>1)
				for(int k=0;k<3;k++)
					if(board[i][k]!="X"&&board[i][k]!="O") {
						board[i][k]="O";
						return;
					}
		}

		for(int i=0;i<board.length;i++) {
			O=0;
			countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[j][i]=="O")
					O++;
				if(board[j][i]!="X"&&board[j][i]!="O")
					countNull++;


			}
			if(O==1&&countNull>1)
				for(int k=0;k<3;k++)
					if(board[k][i]!="X"&&board[k][i]!="O") {
						board[k][i]="O";
						return;
					}
		}


		O=0;
		countNull=0;
		for(int i=0;i<3;i++) {

			if(board[i][i]=="O")
				O++;
			if(board[i][i]!="X"&&board[i][i]!="O")
				countNull++;
		}
		if(O==1&&countNull>1)
			for(int i=0;i<3;i++)
				if(board[i][i]!="X"&&board[i][i]!="O") {
					board[i][i]="O";
					return;
				}



		O=0;
		countNull=0;
		for(int k=2,i=0;i<3;i++,k--) {
			if(board[i][k]=="O")
				O++;
			if(board[i][i]!="X"&&board[i][i]!="O")
				countNull++;
		}
		if(O==1&&countNull>1)
			for(int k=2,i=0;i<3;i++,k--)
				if(board[i][k]!="X"&&board[i][k]!="O") {
					board[i][k]="O";
					return;
				}





		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(board[i][j]!="X"&&board[i][j]!="O") {
					board[i][j]="O";
					return;
				}


		/*/	for(int i=0;i<board.length;i++) {
			x=0;
			countNull=0;
			for(int j=0;j<board.length;j++) {
				if(board[i][j]=="x")
					x++;
				if(board[i][j]!="x"&&board[i][j]!="O")
					countNull++;

			}
			if(x==1&&countNull==2)
				for(int k=0;k<3;k++)
					if(board[i][k]!="x") {
						board[i][k]="O";
						return;
					}
		}

		/*/

	}

	/*/

	public void Startgame() {
		printBoard();
		int i=0;
		while(i<4) {
			playerTurn();
			if(checkfinish()==true) {
				System.out.println("****** YOU WON ******");
				printBoard();
				return;
			}
			System.out.println("********************************");
			printBoard();


			BotTurn();
			if(checkfinish()==true) {
				System.out.println("****** THE BOT WON ******");
				printBoard();
				return;	
			}
			System.out.println("********************************");
			printBoard();
			i++;
		}

		playerTurn();
		if(checkfinish()==true) 
			System.out.println("****** YOU WON ******");
		else System.out.println("it's a draw ");

		System.out.println("********************************");
		printBoard();

	}
/*/
}


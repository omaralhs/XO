package main;

import java.lang.Character.UnicodeBlock;

import java.nio.channels.Channel;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public String prefix="!";
	public static game g=new game();
	public static boolean OnGame =false;
	public static String PlayerName;
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String args[]=event.getMessage().getContentRaw().split(" ");
		String args1=event.getMessage().getContentRaw();
		
		if(OnGame==true&&args[0].equalsIgnoreCase(prefix+"BOB")) {
			event.getChannel().sendMessage("!!!!! CAN'T U SEE I AM IN A FUCKING GAME. SO STFU AND WAIT FOR UR TURN").queue();
			return;
		}
		
			
		if(args[0].equalsIgnoreCase(prefix+"BOB")) {
			PlayerName=event.getAuthor().getAsTag();
			OnGame=true;
			g.printBoard(event);
			
		}
		if(event.getAuthor().isBot()&&!args1.equalsIgnoreCase("!!!! YOU LOST !!!!")&&!args1.equalsIgnoreCase("!!!! YOU WON !!!!")&&!args1.equalsIgnoreCase("!!!! IT'S A DRAW !!!!")&&!args1.equalsIgnoreCase("!!!!! CAN'T U SEE I AM IN A FUCKING GAME. SO STFU AND WAIT FOR UR TURN")&&OnGame==true&&!args1.equalsIgnoreCase("WAIT FOR UR TURN NIGGER !!!!!"))
			g.addReactfunc(event,Reaction.g.board);


		if(args1.equalsIgnoreCase("!!!! IT'S A DRAW !!!!")||args1.equalsIgnoreCase("!!!! YOU LOST !!!!")&&event.getAuthor().isBot())
			OnGame=false;
			
			
			
			

//event.getMessage().addReaction("U+003"+1+" U+FE0F U+20E3").queue();

			/*/
		String args[]=event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(prefix+"start")&&OnGame==false) {
			game g=new game();
			g.printBoard(event);
			while(OnGame==true) {

			}



		//	event.getMessage().addReaction("U+0030 U+FE0F U+20E3").queue();	
		}
		else {
			event.getChannel().sendMessage("STFU, I AM ALREADY IN A GAME CAN'T U SEE!!!!").queue();

		}
		/*/
		}
	}


package main;

import java.nio.channels.Channel;


import net.dv8tion.jda.api.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reaction extends ListenerAdapter {
	public static game g=new game();

	public void onGuildMessageReactionAdd( GuildMessageReactionAddEvent  event) {
		
		if(!event.getUser().getAsTag().equals(Commands.PlayerName)&&!event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			event.getReaction().removeReaction().queue();
			event.getChannel().sendMessage("WAIT FOR UR TURN NIGGER !!!!!").queue();
			return;
		}
		
		
		
		
		if(!event.getMember().getUser().equals(event.getJDA().getSelfUser())){
			
			if(event.getReactionEmote().toString().equals("RE:U+1f3f3")) {
				Commands.OnGame=false;
				g.buildTable(g.board);
				Commands.PlayerName="";
				event.getChannel().deleteMessageById(event.getMessageId()).queue();
				return;
			}
				
			char c=event.getReactionEmote().toString().charAt(6);
			String place=""+c;
			g.BotPlace(place);
			if(g.checkfinish()==true) {
				Commands.OnGame=false;
				event.getChannel().deleteMessageById(event.getMessageId()).queue();
				g.printBoard(event);
				event.getChannel().sendMessage("!!!! YOU WON !!!!").queue();
				g.buildTable(g.board);
				Commands.PlayerName="";
				return;
			}

			if(g.isDRAW()==true) {
				Commands.OnGame=false;
				event.getChannel().deleteMessageById(event.getMessageId()).queue();
				g.printBoard(event);
				event.getChannel().sendMessage("!!!! IT'S A DRAW !!!!").queue();
				g.buildTable(g.board);
				Commands.PlayerName="";
				return;
			}

			g.BotTurn();
			if(g.checkfinish()==true) {
				Commands.OnGame=false;
				event.getChannel().deleteMessageById(event.getMessageId()).queue();
				g.printBoard(event);	
				event.getChannel().sendMessage("!!!! YOU LOST !!!!").queue( );
				g.buildTable(g.board);
				Commands.PlayerName="";
				return;
			}
			event.getChannel().deleteMessageById(event.getMessageId()).queue();
			g.printBoard(event);


		}
	}
}


/*/		
	event.getMessage().addReaction("U+0030 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0031 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0032 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0033 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0034 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0035 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0036 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0037 U+FE0F U+20E3").queue();
	event.getMessage().addReaction("U+0038 U+FE0F U+20E3").queue();	
	event.getMessage().addReaction("U+0039 U+FE0F U+20E3").queue();
/*/
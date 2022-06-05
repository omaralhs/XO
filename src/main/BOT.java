package main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class BOT {
	public game g=new game();
	public static boolean OnGame =false;

	
	public static void main(String[] args) throws LoginException {
		JDABuilder jda = JDABuilder.createDefault("OTc3MTk0MDYxNjUzOTk5NjI2.G4VMeT.fK_LbkbI0xEih1aiEnn3PCQfGOGuHHKny2fRcQ");
		jda.setActivity(Activity.playing(" with Lori's mom"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.addEventListeners(new Reaction());
								
		jda.build();
	}
	

}


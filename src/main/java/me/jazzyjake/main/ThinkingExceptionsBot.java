package me.jazzyjake.main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.PrivateChannel;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.ResourceBundle;

public class ThinkingExceptionsBot {
    public static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("application");
    private static final MessageEmbed STARTUP_EMBED = new EmbedBuilder()
            .setTitle("Thinking Exceptions Bot Guide")
            .setDescription("React to one of the emojis below to log a thinking exception\n" +
                    "\n" +
                    "Catastrophizing - \uD83C\uDF0B\n" +
                    "Mind reading - \uD83E\uDDD0\n" +
                    "Fortune telling - \uD83D\uDD2E\n" +
                    "Magnifying - \uD83D\uDD0E\n" +
                    "Discounting the positive - \uD83E\uDDFE\n" +
                    "Personalization - \uD83E\uDD2F\n" +
                    "Minimizing - (minus symbol ➖)")
            .setColor(Color.WHITE)
            .build();

    public static void main(String[] args) {
        try {
            JDA bot = JDABuilder.createDefault(PROPERTIES.getString("TOKEN")).build();

            // Sends the startup message to the user provided
            PrivateChannel channel = bot.getPrivateChannelById(PROPERTIES.getString("USER_ID"));
            channel.sendMessageEmbeds(STARTUP_EMBED).queue();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}

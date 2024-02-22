package net.mamesosu.Discord;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Command extends ListenerAdapter {

    // on slash command pattern
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {

        // profile
        switch (e.getName()) {
            case "profile" -> {

            }
        }
    }

    // on text command pattern
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        //profile
        if(e.getMessage().getContentRaw().equals("?mp") || e.getMessage().getContentRaw().equals("?profile")) {

        }
    }
}

package io.github.shaksternano.mediamanipulator.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GarbageCollectorCommand extends BotOwnerCommand {

    /**
     * Creates a new command object.
     *
     * @param name        The name of the command. When a user sends a message starting with {@link Command#PREFIX}
     *                    followed by this name, the command will be executed.
     * @param description The description of the command. This is displayed in the help command.
     */
    public GarbageCollectorCommand(String name, String description) {
        super(name, description);
    }

    @Override
    protected void botOwnerOperation(String[] arguments, MessageReceivedEvent event) {
        event.getMessage().reply("Running garbage collector!").queue();
        System.gc();
    }
}

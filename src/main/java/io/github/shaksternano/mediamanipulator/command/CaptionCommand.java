package io.github.shaksternano.mediamanipulator.command;

import io.github.shaksternano.mediamanipulator.mediamanipulation.MediaManipulator;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.IOException;

public class CaptionCommand extends MediaCommand {

    public static final CaptionCommand INSTANCE = new CaptionCommand("caption", "Captions a media file.");

    protected CaptionCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public File applyOperation(File mediaFile, String[] arguments, MediaManipulator manipulator, MessageReceivedEvent event) throws IOException {
        return manipulator.caption(mediaFile, String.join(" ", arguments));
    }
}

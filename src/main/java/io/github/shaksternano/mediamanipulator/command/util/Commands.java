package io.github.shaksternano.mediamanipulator.command.util;

import io.github.shaksternano.mediamanipulator.command.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains registered {@link Command}s.
 */
@SuppressWarnings("unused")
public class Commands {

    private static final List<Command> commandsToRegister = new ArrayList<>();
    private static final DecimalFormat FORMAT = new DecimalFormat("0.####");

    /**
     * The caption {@link Command}.
     */
    public static final Command CAPTION = addCommandToRegister(new CaptionCommand(
            "caption",
            "Captions a media file."
    ));

    public static final Command SPIN = addCommandToRegister(new SpinCommand(
            "spin",
            "Spins a media file. Optional arguments: [spin speed, default value is " + FORMAT.format(SpinCommand.DEFAULT_SPIN_SPEED) + "], [background RGB colour, by default it is transparent]."
    ));

    /**
     * The stretch {@link Command}.
     */
    public static final Command STRETCH = addCommandToRegister(new StretchCommand(
            "stretch",
            "Stretches media with extra processing to smoothen the resulting image. Optional arguments: [width stretch multiplier, default value is " + FORMAT.format(StretchCommand.DEFAULT_WIDTH_MULTIPLIER) + "], [height stretch multiplier, default value is " + FORMAT.format(StretchCommand.DEFAULT_HEIGHT_MULTIPLIER) + "]",
            false
    ));

    public static final Command STRETCH_RAW = addCommandToRegister(new StretchCommand(
            "stretchraw",
            "Stretches media without extra processing. Optional arguments: [width stretch multiplier, default value is " + FORMAT.format(StretchCommand.DEFAULT_WIDTH_MULTIPLIER) + "], [height stretch multiplier, default value is " + FORMAT.format(StretchCommand.DEFAULT_HEIGHT_MULTIPLIER) + "]",
            true
    ));

    public static final Command RESIZE = addCommandToRegister(new ResizeCommand(
            "resize",
            "Resizes media with extra processing to smoothen the resulting image. Equivalent to " + Command.PREFIX + STRETCH.getName() + " x x. Required arguments: [resize multiplier]",
            false
    ));

    public static final Command RESIZE_RAW = addCommandToRegister(new ResizeCommand(
            "resizeraw",
            "Resizes media without extra processing. Equivalent to " + Command.PREFIX + STRETCH_RAW.getName() + " x x. Required arguments: [resize multiplier]",
            true
    ));

    public static final Command SPEED = addCommandToRegister(new SpeedCommand(
            "speed",
            "Speeds up or slows down media. Optional arguments: [speed multiplier, default value is " + FORMAT.format(SpeedCommand.DEFAULT_SPEED_MULTIPLIER) + "]"
    ));

    public static final Command PIXELATE = addCommandToRegister(new PixelateCommand(
            "pixel",
            "Pixelates media. Equivalent to " + Command.PREFIX + RESIZE_RAW.getName() + " 1/x followed by " + Command.PREFIX + RESIZE_RAW.getName() + " x Optional arguments: [pixelation multiplier, default value is " + FORMAT.format(PixelateCommand.DEFAULT_PIXELATION_MULTIPLIER) + "]"
    ));

    public static final Command REDUCE_FPS = addCommandToRegister(new ReduceFpsCommand(
            "redfps",
            "Reduces the FPS of a media file. Optional arguments: [fps reduction multiplier, default value is " + FORMAT.format(ReduceFpsCommand.DEFAULT_FPS_REDUCTION_MULTIPLIER) + "]"
    ));

    /**
     * The speech bubble {@link Command}.
     */
    public static final Command SPEECH_BUBBLE = addCommandToRegister(new SpeechBubbleCommand(
            "sb",
            "Overlays a speech bubble over media.",
            false
    ));

    public static final Command INVERTED_SPEECH_BUBBLE = addCommandToRegister(new SpeechBubbleCommand(
            "sbi",
            "Cuts out a speech bubble from media (Inverted speech bubble).",
            true
    ));

    public static final Command ROTATE = addCommandToRegister(new RotateCommand(
            "rotate",
            "Rotates media. Optional arguments: [Rotation amount, default value is " + FORMAT.format(RotateCommand.DEFAULT_ROTATION) + "], [background RGB colour, by default it is transparent]."
    ));

    /**
     * Turns media into a GIF file.
     */
    public static final Command TO_GIF = addCommandToRegister(new ToGifCommand(
            "gif",
            "Turns media into a GIF file.",
            false
    ));

    public static final Command TO_GIF_2 = addCommandToRegister(new ToGifCommand(
            "gif2",
            "Turns media into a GIF file by just renaming the file extension to \".gif\". Use this when there are problems with the " + Command.PREFIX + TO_GIF.getName() + " command.",
            true
    ));

    public static final Command TO_PNG = addCommandToRegister(new ToPngCommand(
            "png",
            "Turns media into a PNG file and adds transparency."
    ));

    public static final Command TO_ICO = addCommandToRegister(new ToIcoCommand(
            "ico",
            "Turns media into an ICO file."
    ));

    public static final Command SERVER_ICON = addCommandToRegister(new ServerIconCommand(
            "servericon",
            "Gets the icon of the server."
    ));

    public static final Command SERVER_BANNER = addCommandToRegister(new ServerBannerCommand(
            "serverbanner",
            "Gets the image of the server banner."
    ));

    public static final Command SERVER_SPLASH = addCommandToRegister(new ServerSplashCommand(
            "serversplash",
            "Gets the image of the server invite background."
    ));

    public static final Command USER_AVATAR = addCommandToRegister(new UserAvatarCommand(
            "avatar",
            "Gets the avatar of a user. Optional arguments: [User mention]"
    ));

    public static final Command USER_BANNER = addCommandToRegister(new UserBannerCommand(
            "banner",
            "Gets the banner of a user. Optional arguments: [User mention]"
    ));

    public static final Command EMOJI_IMAGE = addCommandToRegister(new EmojiImageCommand(
            "emoji",
            "Gets the image of an emoji."
    ));

    public static final Command STICKER_IMAGE = addCommandToRegister(new StickerImageCommand(
            "sticker",
            "Gets the image of a sticker."
    ));

    public static final Command MEMORY_USAGE = addCommandToRegister(new MemoryUsageCommand(
            "memory",
            "Get the memory usage of the bot."
    ));

    public static final Command GARBAGE_COLLECTOR = addCommandToRegister(new GarbageCollectorCommand(
            "gc",
            "Runs the garbage collector."
    ));

    /**
     * The shut-down {@link Command}.
     */
    public static final Command SHUT_DOWN = addCommandToRegister(new ShutDownCommand(
            "shutdown",
            "Shuts down the bot."
    ));

    /**
     * The help {@link Command}.
     */
    public static final Command HELP = addCommandToRegister(new HelpCommand(
            "help",
            "Lists all commands."
    ));

    private static <T extends Command> T addCommandToRegister(T command) {
        commandsToRegister.add(command);
        return command;
    }

    /**
     * Registers all the {@link Command}s.
     */
    public static void registerCommands() {
        CommandRegistry.register(commandsToRegister);
    }
}

package io.github.shaksternano.mediamanipulator.util;

import io.github.shaksternano.mediamanipulator.Main;
import io.github.shaksternano.mediamanipulator.io.FileUtil;

import java.awt.*;
import java.io.IOException;

/**
 * Handles custom fonts.
 */
public class Fonts {

    /**
     * Registers the custom fonts.
     */
    public static void registerFonts() {
        FileUtil.forEachResource("font", (resourcePath, inputStream) -> {
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            } catch (FontFormatException | IOException e) {
                Main.getLogger().error("Could not load font " + resourcePath, e);
            }
        });
    }
}

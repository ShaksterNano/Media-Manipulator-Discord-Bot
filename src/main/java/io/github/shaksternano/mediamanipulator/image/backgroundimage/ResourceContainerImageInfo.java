package io.github.shaksternano.mediamanipulator.image.backgroundimage;

import io.github.shaksternano.mediamanipulator.Main;
import io.github.shaksternano.mediamanipulator.image.imagemedia.ImageMedia;
import io.github.shaksternano.mediamanipulator.image.util.ImageUtil;
import io.github.shaksternano.mediamanipulator.io.FileUtil;
import io.github.shaksternano.mediamanipulator.util.Fonts;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public enum ResourceContainerImageInfo implements ContainerImageInfo {

    SONIC_SAYS(
            "image/containerimage/sonic_says.jpg",
            "sonic_says",
            345,
            35,
            630,
            490,
            60,
            true,
            null,
            Fonts.getCustomFont("bitstream_vera_sans"),
            Color.WHITE,
            100
    ),

    SOYJAK_POINTING(
            "image/containerimage/soyjak_pointing.png",
            "soyjak_pointing",
            0,
            0,
            1024,
            810,
            0,
            250,
            150,
            500,
            300,
            0,
            false,
            null,
            Fonts.getCustomFont("futura_condensed_extra_bold"),
            Color.BLACK,
            100
    );

    private final String IMAGE_PATH;
    private final String RESULT_NAME;
    private final int IMAGE_CONTENT_X;
    private final int IMAGE_CONTENT_Y;
    private final int IMAGE_CONTENT_WIDTH;
    private final int IMAGE_CONTENT_HEIGHT;
    private final int TEXT_CONTENT_X;
    private final int TEXT_CONTENT_Y;
    private final int TEXT_CONTENT_WIDTH;
    private final int TEXT_CONTENT_HEIGHT;
    private final boolean IS_BACKGROUND;
    @Nullable
    private final Color FILL;
    private final Font FONT;
    private final Color TEXT_COLOR;

    ResourceContainerImageInfo(
            String imagePath,
            String resultName,
            int contentContainerX,
            int contentContainerY,
            int contentContainerWidth,
            int contentContainerHeight,
            int contentContainerPadding,
            boolean isBackground,
            @Nullable Color fill,
            Font font,
            Color textColor,
            float maxFontSize
    ) {
        IMAGE_PATH = imagePath;
        RESULT_NAME = resultName;
        IMAGE_CONTENT_X = contentContainerX + contentContainerPadding;
        IMAGE_CONTENT_Y = contentContainerY + contentContainerPadding;
        TEXT_CONTENT_X = contentContainerX + contentContainerPadding;
        TEXT_CONTENT_Y = contentContainerY + contentContainerPadding;
        int doublePadding = contentContainerPadding * 2;
        IMAGE_CONTENT_WIDTH = contentContainerWidth - doublePadding;
        IMAGE_CONTENT_HEIGHT = contentContainerHeight - doublePadding;
        TEXT_CONTENT_WIDTH = contentContainerWidth - doublePadding;
        TEXT_CONTENT_HEIGHT = contentContainerHeight - doublePadding;
        IS_BACKGROUND = isBackground;
        FILL = fill;
        FONT = font.deriveFont(maxFontSize);
        TEXT_COLOR = textColor;
    }

    ResourceContainerImageInfo(
            String imagePath,
            String resultName,
            int imageContainerX,
            int imageContainerY,
            int imageContainerWidth,
            int imageContainerHeight,
            int imageContainerPadding,
            int textContainerX,
            int textContainerY,
            int textContainerWidth,
            int textContainerHeight,
            int textContainerPadding,
            boolean isBackground,
            @Nullable Color fill,
            Font font,
            Color textColor,
            float maxFontSize
    ) {
        IMAGE_PATH = imagePath;
        RESULT_NAME = resultName;
        IMAGE_CONTENT_X = imageContainerX + imageContainerPadding;
        IMAGE_CONTENT_Y = imageContainerY + imageContainerPadding;
        TEXT_CONTENT_X = textContainerX + textContainerPadding;
        TEXT_CONTENT_Y = textContainerY + textContainerPadding;
        int doubleImagePadding = imageContainerPadding * 2;
        int doubleTextPadding = textContainerPadding * 2;
        IMAGE_CONTENT_WIDTH = imageContainerWidth - doubleImagePadding;
        IMAGE_CONTENT_HEIGHT = imageContainerHeight - doubleImagePadding;
        TEXT_CONTENT_WIDTH = textContainerWidth - doubleTextPadding;
        TEXT_CONTENT_HEIGHT = textContainerHeight - doubleTextPadding;
        IS_BACKGROUND = isBackground;
        FILL = fill;
        FONT = font.deriveFont(maxFontSize);
        TEXT_COLOR = textColor;
    }

    @Override
    public ImageMedia getImage() throws IOException {
        return ImageUtil.getImageResource(IMAGE_PATH);
    }

    @Override
    public String getResultName() {
        return RESULT_NAME;
    }

    @Override
    public int getImageContentX() {
        return IMAGE_CONTENT_X;
    }

    @Override
    public int getImageContentY() {
        return IMAGE_CONTENT_Y;
    }

    @Override
    public int getImageContentWidth() {
        return IMAGE_CONTENT_WIDTH;
    }

    @Override
    public int getImageContentHeight() {
        return IMAGE_CONTENT_HEIGHT;
    }

    @Override
    public int getTextContentX() {
        return TEXT_CONTENT_X;
    }

    @Override
    public int getTextContentY() {
        return TEXT_CONTENT_Y;
    }

    @Override
    public int getTextContentWidth() {
        return TEXT_CONTENT_WIDTH;
    }

    @Override
    public int getTextContentHeight() {
        return TEXT_CONTENT_HEIGHT;
    }

    @Override
    public boolean isBackground() {
        return IS_BACKGROUND;
    }

    @Override
    public Optional<Color> getFill() {
        return Optional.ofNullable(FILL);
    }

    @Override
    public Font getFont() {
        return FONT;
    }

    @Override
    public Color getTextColor() {
        return TEXT_COLOR;
    }

    public static void validateFilePaths() {
        for (ResourceContainerImageInfo backgroundImage : ResourceContainerImageInfo.values()) {
            try {
                FileUtil.validateResourcePath(backgroundImage.IMAGE_PATH);
            } catch (Throwable t) {
                Main.getLogger().error("Error with " + backgroundImage + "'s file path " + backgroundImage.IMAGE_PATH, t);
                Main.shutdown(1);
            }
        }
    }
}

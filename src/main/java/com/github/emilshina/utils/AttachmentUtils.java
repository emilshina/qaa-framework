package com.github.emilshina.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

/**
 * Utility class for attachments.
 */

@UtilityClass
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class AttachmentUtils {

    @Attachment(value = "{name}", type = "text/uri-list")
    public static String attachUri(final String name, final String data) {
        return data;
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attacLog(final String name, final String data) {
        return data;
    }
}

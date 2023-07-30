/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.telegram.model;

import java.io.Serial;
import java.util.Arrays;
import java.util.Objects;

/**
 * An outgoing animation message. <a href="https://core.telegram.org/bots/api#sendanimation">API</a>
 */
public final class OutgoingAnimationMessage extends OutgoingMessage {

    @Serial
    private static final long serialVersionUID = -7553271271236969370L;

    private final byte[] animation;
    private final String animationStr;
    private final String caption;

    private final String fileName;

    private final String extension;

    private OutgoingAnimationMessage(byte[] animation,
                                     String caption,
                                     String fileName,
                                     String extension,
                                     Boolean disableNotification,
                                     Long replyToMessageId) {
        this.animation = animation;
        this.caption = caption;
        this.fileName = fileName;
        this.extension = extension;
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;

        this.animationStr = null;
    }

    private OutgoingAnimationMessage(String animation,
                                     String caption,
                                     Boolean disableNotification,
                                     Long replyToMessageId) {
        this.animationStr = animation;
        this.caption = caption;
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;

        this.animation = null;
        this.fileName = null;
        this.extension = null;
    }

    /**
     * Creates {@link OutgoingStickerMessage} based on a given animation file.
     *
     * @param animationFile The animation file
     * @param fileName      Filename to use in multipart/form-data
     * @param extension     Extension of the file to use in multipart/form-data
     * @param caption       Optional. Animation caption (may also be used when resending animation by file_id), 0-1024
     *                      characters after entities parsing
     * @return Sticker message.
     */
    public static OutgoingAnimationMessage createWithFile(
            byte[] animationFile,
            String fileName,
            String extension,
            String caption) {
        Objects.requireNonNull(animationFile);
        Objects.requireNonNull(fileName);
        Objects.requireNonNull(extension);
        return new OutgoingAnimationMessage(animationFile, caption, fileName, extension, null, null);
    }

    /**
     * Creates {@link OutgoingStickerMessage} based on a given animation string (file_id or url).
     *
     * @param animationString Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet
     * @param caption         Optional. Animation caption (may also be used when resending animation by file_id), 0-1024
     *                        characters after entities parsing
     * @return Sticker message.
     */
    public static OutgoingAnimationMessage createWithString(
            String animationString,
            String caption) {
        Objects.requireNonNull(animationString);
        return new OutgoingAnimationMessage(animationString, caption, null, null);
    }

    public byte[] getAnimationFile() {
        return animation;
    }

    public String getAnimationString() {
        return animationStr;
    }

    public String getCaption() {
        return caption;
    }

    public String getFileNameWithExtension() {
        return String.format("%s.%s", fileName, extension);
    }

    @Override
    public String toString() {
        return "OutgoingAnimationMessage{" +
                "animation=" + Arrays.toString(animation) +
                ", caption='" + caption + '\'' +
                ", fileName='" + fileName + '\'' +
                ", extension='" + extension + '\'' +
                ", chatId='" + chatId + '\'' +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                '}';
    }
}

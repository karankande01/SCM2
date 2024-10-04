package com.scm.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    public String content;
    @Builder.Default
    public MessageType type = MessageType.green;
}

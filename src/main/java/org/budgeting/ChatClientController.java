
package org.budgeting;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatClientController {
    private final ChatClient ChatClient;

    public ChatClientController(ChatClient ChatClient) {
        this.ChatClient = ChatClient;
    }

    @GetMapping("/chat")
    String chat(String prompt) {
        return this.ChatClient.prompt().user(prompt).call().content();
    }
}

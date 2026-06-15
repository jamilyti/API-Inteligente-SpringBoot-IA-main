package org.budgeting;

import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named="OPENAI_API_KEY", matches=".+")

public class OpenAiTranscriptionModelIT {
    @Autowired
    OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

    @ParameterizedTest
    @CsvSource({
                "audio_teste_1.wav, 80 reais",
                "audio_teste_2.wav, 40 reais",
                "audio_teste_3.wav, 120 reais",
//                "audio_teste_1.wav, 90 reais",
//                "audio_teste_2.wav, 200 reais",
//                "audio_teste_3.wav, 60 reais",
    })
    public void should_containExpectedKeywords_when_audioFilesAreProcessed(String fileName, String expectedKeyword ) {
        var recording = new ClassPathResource("audio/" + fileName);
        var response = openAiAudioTranscriptionModel.call(recording);

        assertThat(response).contains(expectedKeyword);
        System.out.println(response);

    }

}

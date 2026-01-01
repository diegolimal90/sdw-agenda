package br.com.sdweb.agenda.configuration.database;

import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.jsr310.Jsr310CodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Importante para resolver o UUID
import static org.bson.UuidRepresentation.STANDARD;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

//@Configuration
public class CodecRegistryConfiguration {

    @Bean
    public CodecRegistry customCodecRegistry() {
        // 1. Obtém o CodecRegistry padrão do MongoDB
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();

        // 2. Adiciona o CodecRegistry com a configuração de UUID
        CodecRegistry customRegistry = fromRegistries(
                defaultCodecRegistry,
                CodecRegistries.fromCodecs(
                        // O driver precisa deste Codec com a configuração correta
                        new org.bson.codecs.UuidCodec(STANDARD)
                ),
                fromProviders(new Jsr310CodecProvider()) // Opcional, mas útil para datas modernas
        );

        return customRegistry;
    }
}
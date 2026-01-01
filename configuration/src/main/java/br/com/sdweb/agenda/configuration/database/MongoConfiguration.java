package br.com.sdweb.agenda.configuration.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static org.bson.UuidRepresentation.STANDARD;

//@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    // Injeta as propriedades de conexão do seu application.yml
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.username}")
    private String user;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public MongoClient mongoClient() {
        String uri = String.format("mongodb://%s:%s@%s:%d", user, password, host, port);

        return MongoClients.create(uri);
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.uuidRepresentation(STANDARD);
    }

    @Bean
    public MongoClientSettingsBuilderCustomizer customizer() {
        return builder -> builder.uuidRepresentation(UuidRepresentation.STANDARD);
        // ou UuidRepresentation.JAVA_LEGACY se necessário
    }
}

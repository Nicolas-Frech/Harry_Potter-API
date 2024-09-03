package hogwarts.express.api_harry_potter.infra;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDoc {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Harry Potter API: Todas as informações sobre o mundo bruxo!")
                        .description("API sobre o mundo de Harry Potter, com informações sobre bruxos, feitiços, livros e mais!")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@voll.med"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://voll.med/api/licenca")));
    }


}

# Spring Security

## Enabling Swagger Specs 

### Dependencies required.

    For Gradle
    compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.0.1'
	compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.0.2'
	compile group: 'io.swagger', name: 'swagger-annotations', version: '1.5.0'


### Configuration required

#### Annotation

1. @Configuration :- This denotes its a Configuration class, which is java based Configuration.
2. @EnableSwagger2 :- In order to generate Swagger documentation, we use this annotation.

##### Steps for Swagger Specs
    Step 1: Annotate the class with @Configuation and @EnableSwagger2
    Step 2: we need to define a method which will create a bean using @Bean annotation.
    Step 3: we create a new instance of Docket bean which is basically a builder class for documentation
    Step 4: We pass the details of Ducmnetation type in the constructor.
    Step 5: select() returns an instance of ApiSelectorBuilder, which controls the endpoints exposed by swagger
    Step 6: apis(RequestHandlerSelectors.basePackage("com.arun.springdata.springdata.Controller")), this specifies the packages which are to be used as endpoint
    Step 7: paths(regex("/employee.*")), it specifies the RequestMapping in the Controller, we can have PathSelectors.any()

Below is an example of Config Class where we need to configure the swagger Specs

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import springfox.documentation.builders.RequestHandlerSelectors;
        import springfox.documentation.spi.DocumentationType;
        import springfox.documentation.spring.web.plugins.Docket;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;
        
        import static springfox.documentation.builders.PathSelectors.regex;
        
        @Configuration
        @EnableSwagger2
        public class Config {
        
            @Bean
            public Docket productAPI(){
                return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.arun.springdata.springdata.Controller"))
                        .paths(regex("/employee.*"))
                        .build();
            }
        }


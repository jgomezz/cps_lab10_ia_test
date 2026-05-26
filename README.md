# Lab 10 - AI Integration Test

Java project demonstrating AI/LLM integration using LangChain4j and direct HTTP calls.

## Requirements

- Java 21+
- Maven 3.9+
- Access to an OpenAI-compatible API server

## Project Structure

```
src/main/java/pe/edu/tecsup/lab10/
├── config/
│   └── AppConfig.java       # Centralized configuration manager
├── CustomIA.java            # AI client using LangChain4j
└── SimpleIA.java            # AI client using direct HTTP

src/test/java/pe/edu/tecsup/lab10/
├── CustomIATest.java        # Tests for CustomIA
└── SimpleIATest.java        # Tests for SimpleIA

src/main/resources/
├── application.properties          # Configuration (gitignored)
└── application.properties.example  # Configuration template
```

## Configuration

1. Copy the example properties file:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

2. Edit `application.properties` with your values:
```properties
openai.base-url=http://your-server:port/api/v1
openai.api-key=your-api-key-here
openai.model-name=your-model-name
```

## Running Tests

```bash
mvn test
```

## Usage

### Using CustomIA (LangChain4j)

```java
import pe.edu.tecsup.lab10.CustomIA;

String response = CustomIA.getModel().chat("Hello, how are you?");
System.out.println(response);
```

### Using SimpleIA (Direct HTTP)

```java
import pe.edu.tecsup.lab10.SimpleIA;

String response = SimpleIA.chat("Hello, how are you?");
System.out.println(response);
```

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| langchain4j-open-ai | 1.15.0 | LangChain4j OpenAI integration |
| langchain4j-http-client-jdk | 1.15.0 | HTTP client for LangChain4j |
| slf4j-simple | 2.0.18 | Logging |
| lombok | 1.18.46 | Reduce boilerplate code |
| junit-jupiter | 5.11.0 | Testing framework |

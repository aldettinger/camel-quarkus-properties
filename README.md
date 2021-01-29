# code-with-quarkus project

This project demonstrates some tips when using configuration properties with Camel Quarkus.

## Running the demo

The application can be packaged using:
```shell script
./mvnw clean test
```

The test should output logs like below:
```
Basic property read from annotation: a-basic-value
Basic property read from ConfigProvider: a-basic-value
Basic property read from camel simple: a-basic-value
The java.util.Properties file format applies: a-value-with-unicode-character-(√9=3)
Property expression read from camel simple: a-value-resolved-via-a-property-expression
Environment variable based property read from camel simple: a-value-with-environment-variable-agallice
Environment variable based property replaced with default: a-value-where-non-existing-environment-variable-is-replaced-by-a-default-value
Environment variable based property replaced with default via property expression: a-value-where-non-existing-environment-variable-is-replaced-with-a-default-value-resolved-via-a-property-expression
```
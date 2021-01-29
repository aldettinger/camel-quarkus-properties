package org.acme;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MyRouteBuilder extends RouteBuilder {

    @ConfigProperty(name = "basic")
    String basicPropertyFromAnnotation;

    @Override
    public void configure() {
        String basicPropertyFromConfigProvider = ConfigProvider.getConfig().getValue("basic", String.class);

        from("platform-http:/print-configs").setBody(simple("{{basic}}")).process(e -> {
            System.out.println("Basic property read from annotation: " + basicPropertyFromAnnotation);
            System.out.println("Basic property read from ConfigProvider: " + basicPropertyFromConfigProvider);
            System.out.println("Basic property read from camel simple: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{unicode}}")).process(e -> {
            System.out.println("The java.util.Properties file format applies: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{property-expression}}")).process(e -> {
            System.out.println("Property expression read from camel simple: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{environment-variable}}")).process(e -> {
            System.out.println("Environment variable based property read from camel simple: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{environment-variable-or-default}}")).process(e -> {
            System.out.println("Environment variable based property replaced with default: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{environment-variable-or-default-via-property-expression}}")).process(e -> {
            System.out.println("Environment variable based property replaced with default via property expression: " + e.getIn().getBody(String.class));
        }).setBody(simple("{{escape-dollar-to-avoid-property-resolution}}")).process(e -> {
            System.out.println("Escaping the dollar makes it possible to use Camel simple date syntax: " + e.getIn().getBody(Date.class));
        }).setBody(constant("That's all folks"));
    }

}

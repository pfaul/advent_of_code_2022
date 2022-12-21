package seyerlein;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ListStringResourceExtension implements ParameterResolver
{
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException
    {
        return parameterContext.isAnnotated(ListStringResource.class)
                && parameterContext.getParameter().getType().equals(List.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException
    {
        String location = parameterContext.findAnnotation(ListStringResource.class).map(ListStringResource::value).orElseThrow();
        try
        {
            URL url = Objects.requireNonNull(getClass().getResource(location));
            URI uri = url.toURI();
            Path path = Path.of(uri);
            return Files.readAllLines(path);
        }
        catch (URISyntaxException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

package de.javagl.jgltf;

import java.nio.ByteBuffer;
import java.util.function.Function;

public final class ResourceAccessor {

    private static String resourceLocationName;

    private static Function<String, ByteBuffer> imageGetter;

    private static Function<String, ByteBuffer> bufferGetter;

    public static String getResourceLocationName() {
        return resourceLocationName;
    }

    public static void setResourceLocationName(String resourceLocationName) {
        ResourceAccessor.resourceLocationName = resourceLocationName;
    }

    public static void setBufferGetter(Function<String, ByteBuffer> bufferGetter) {
        ResourceAccessor.bufferGetter = bufferGetter;
    }

    public static void setImageGetter(Function<String, ByteBuffer> imageGetter) {
        ResourceAccessor.imageGetter = imageGetter;
    }

    public static ByteBuffer getBufferResource(String resourceLocation){
        return bufferGetter.apply(resourceLocation);
    }

    public static ByteBuffer getImageResource(String resourceLocation){
        return imageGetter.apply(resourceLocation);
    }
}

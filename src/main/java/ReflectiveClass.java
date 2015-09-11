import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class ReflectiveClass {
    public static Class loadClass(String path, String name) {
        Class classToLoad = null;
        File f = new File(path);
        try {
            URL[] cp = {f.toURI().toURL()};
            URLClassLoader urlcl = new URLClassLoader(cp);
            classToLoad = urlcl.loadClass(name);
        } catch (ClassNotFoundException e){
            System.out.println("Can`t find class on path " + path);
        } catch(MalformedURLException e){
            System.out.println("Problem with path " + path);
        }
        return classToLoad;
    }

    public static Object createInstance(Class clazz){
        Object instance = null;
        try{
            instance =clazz.newInstance();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return instance;
    }

}

package com.gome.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MycalssLoader extends ClassLoader{
        private String classPath;
        public MycalssLoader(String classPath){
            this.classPath=classPath;
        }
        private byte[] loadByte(String name) throws  Exception{
            name = name.replaceAll("\\.", "/");
            FileInputStream fileInputStream = new FileInputStream(classPath + "/" + name + ".class");
            int available = fileInputStream.available();
            byte[] data=new byte[available];
            fileInputStream.read(data);
            fileInputStream.close();
            return  data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] b = loadByte(name);
                return  defineClass(name,b,0,b.length);
            } catch (Exception e) {
                throw  new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    if(!name.startsWith("com.gome.classloader")){
                        c=this.getParent().loadClass(name);
                    }else {
                        c = findClass(name);
                    }
                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args) throws  Exception{
        MycalssLoader classLoader = new MycalssLoader("/Users/zhaokun/Documents/jvm/test");
        Class clazz = classLoader.loadClass("com.gome.classloader.User1");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}

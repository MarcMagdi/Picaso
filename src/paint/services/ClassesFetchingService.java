package paint.services;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import paint.models.ShapePicaso;

/**
 * . Provide the Main services for dynamic class loading
 * 
 * @author Bishoy Nader & Marc Magdi
 *
 */
public abstract class ClassesFetchingService {

	/**
	 * Splits the name of class without its extension.
	 * 
	 * @param fileName
	 *            the name of the file with its extension
	 * @return the name of class without its extension
	 */
	public static String nameWithoutExtension(final String fileName) {
		return fileName.split("\\.")[0];
	}

	/**
	 * 
	 * 
	 * @return List of the dynamic loaded classes from a predefined path
	 */
	public static List<Class<?>> getModelClasses() {
		return getAllClasses("paint.models");
	}

	public static List<Class<?>> getAllClasses(String pckgname) {
		try {
			List<Class<?>> classes = new ArrayList();
			// Get a File object for the package
			File directory = null;
			try {
				directory = new File(Thread.currentThread().getContextClassLoader()
						.getResource(pckgname.replace('.', '/')).getFile());
			} catch (NullPointerException x) {
				throw new ClassNotFoundException(pckgname + " does not appear to be a valid package");
			}
			if (directory.exists()) {
				// Get the list of the files contained in the package
				String[] files = directory.list();
				for (int i = 0; i < files.length; i++) {
					// we are only interested in .class files
					if (files[i].endsWith(".class")) {
						// removes the .class extension
						Class<?> classToCheck = Class.forName(pckgname + '.' + files[i].substring(0, files[i].length() - 6));
						if (isAbstract(classToCheck)) {
							classes.add(classToCheck);
						}
					}
				}
			} else {
				throw new ClassNotFoundException(pckgname + " does not appear to be a valid package");
			}

			return classes;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * . Load all classes from a jar file
	 * 
	 * @param file
	 *            the file to load from
	 * @return List of loaded classes
	 * @throws Exception
	 */
	public static List<Class<?>> getModelClasses(File file) throws Exception {
		List<Class<?>> classesObjects = new ArrayList<Class<?>>();
		JarFile jarFile = new JarFile(file);
		Enumeration<JarEntry> e = jarFile.entries();

		URL[] urls = { new URL("jar:file:" + file.getAbsolutePath() + "!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		while (e.hasMoreElements()) {
			JarEntry je = e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			// -6 because of .class
			String className = je.getName().substring(0, je.getName().length() - 6);
			className = className.replace('/', '.');
			classesObjects.add(cl.loadClass(className));
		}

		jarFile.close();
		return classesObjects;
	}

	/**
	 * . Get Class by it's name
	 * 
	 * @param className
	 *            the class name to search with
	 * @return Class object
	 */
	public static Class<?> getClass(final String className, final String str) {
		// String str = Constants.MODELS_PATH_MARC;
		Class<?> classToReturn = null;
		ClassLoader classLoader = null;
		try {
			// Convert File to a URL
			File file = new File(str);

			// convert the file to URL format
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };

			// load this folder into Class loader
			classLoader = new URLClassLoader(urls);

			// load the Address class in 'c:\\other_classes\\'
			classToReturn = classLoader.loadClass("paint.models." + className);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return classToReturn;
		}
	}

	public static Class<?> getClass(final String className, File file) {

		// TODO: validate that class parent is already loaded in memory!

		Class<?> classToReturn = null;
		ClassLoader classLoader = null;
		try {
			// convert the file to URL format
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };

			// load this folder into Class loader
			classLoader = new URLClassLoader(urls);

			// load the Address class in 'c:\\other_classes\\'
			classToReturn = classLoader.loadClass("paint.models." + className);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return classToReturn;
		}
	}

	/**
	 * .
	 * 
	 * @param classObject
	 *            the class object to check
	 * @return true if it's and abstract class
	 */
	private static boolean isAbstract(final Class<?> classObject) {
		if (classObject != null && !(Modifier.isAbstract(classObject.getModifiers()))) {
			return true;
		}
		return false;
	}
	
	public static Class<? extends ShapePicaso> getClassForDecoding(String pckgname, String ClassName) {
		try {
			// Get a File object for the package
			File directory = null;
			try {
				directory = new File(Thread.currentThread().getContextClassLoader()
						.getResource(pckgname.replace('.', '/')).getFile());
			} catch (NullPointerException x) {
				System.out.println("Nullpointer");
				throw new ClassNotFoundException(pckgname + " does not appear to be a valid package");
			}
			if (directory.exists()) {
				// Get the list of the files contained in the package
				String[] files = directory.list();
				for (int i = 0; i < files.length; i++) {
					// we are only interested in .class files
					if (files[i].endsWith(".class")) {
						// removes the .class extension
						String nameWithoutExtension = files[i].substring(0, files[i].length() - 6);
						if(nameWithoutExtension.equals(ClassName)) {
							Class<? extends ShapePicaso> classToCheck = (Class<? extends ShapePicaso>) Class.forName(pckgname + '.' + nameWithoutExtension);
							if (isAbstract(classToCheck)) {
								return classToCheck;
							}
						}
					}
				}
			} else {
				System.out.println("Directory does not exist");
				throw new ClassNotFoundException(pckgname + " does not appear to be a valid package");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

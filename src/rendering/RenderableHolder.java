package rendering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RenderableHolder {
	private ArrayList<Renderable> objects;
	private static final RenderableHolder INSTANCE = new RenderableHolder();
	private Comparator<Renderable> comparator;
	
	public RenderableHolder() {
		objects = new ArrayList<Renderable>();
		comparator = (Renderable o1, Renderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public void clear() {
		objects.clear();
	}
	
	public void add(Renderable object) {
		objects.add(object);
		Collections.sort(objects, comparator);
	}
	
	public ArrayList<Renderable> getObjects() {
		return objects;
	}
	
	public void setObjects(ArrayList<Renderable> arr) {
		objects = arr;
		Collections.sort(objects, comparator);
	}

	public static RenderableHolder getInstance() {
		return INSTANCE;
	}
}

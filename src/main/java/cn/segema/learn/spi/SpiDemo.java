package cn.segema.learn.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemo {

	public static void main(String[] args) {
		ServiceLoader<IParseDoc> iParseDocs  = ServiceLoader.load(IParseDoc.class);

		Iterator<IParseDoc> iParseDocIterator = iParseDocs.iterator();
		while(iParseDocIterator.hasNext()) {
			iParseDocIterator.next().parse();
		}
		
	}

}

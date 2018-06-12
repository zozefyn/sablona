/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Sablona {
	private String obsah = "";

	public Sablona (String cesta) {
		try {

			byte [] encoded = Files.readAllBytes (Paths.get(cesta));
			obsah = new String (encoded);
		} catch (IOException e) {
			System.out.println ("Error; unable to read template from '" + cesta + "': " +e);
			System.exit(3);

		}
	}
	public Sablona () {

	}
	public void setTemplate (String obsah) {
		this.obsah = obsah;
	
	}
	public String render (Map<String, String> nahrady) {
		String vysledek = new String (obsah);
		for (Map.Entry<String, String> entry: nahrady.entrySet ()) {
			vysledek = vysledek.Replace ("{{ "+ entry.getKey ()+ " }}", entry.getValue ());		//misto klicovych slov dosadi vyslednou hodnotu
		}
		return vysledek;
	}
}	

	
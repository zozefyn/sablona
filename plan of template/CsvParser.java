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
import java.util.List;
import java.util.HashMap;

public class CsvParser {
	private List <String> lines;
	private String [] headers;

	public CsvParser (String cesta)
		try {

			lines = Files.readAllLines (Paths.get(cesta));
		} catch (IOException e) {
			System.out.println ("Error; unable to read CSV from '" + cesta + "': " +e);
			System.exit(4)

		}
		headers = lines.remove(0).split(",");

	public Map <String, String> getNextReplacements () {

		while (lines.size ()>0) {
			String line = lines.remove (0);
			String [] hodnoty = line.split(",");
			if(hodnoty.length != headers.length) {
				System.out.println ("Warn: ignoring CSV line for it does not match the headers:" + line)
				//pokud ma nespravnou strukturu, hlasi chybu a jede dal
			} else {
				Map <String, String> nahrady = new HashMap <String, String> ();

				for (int i = 0;i < hodnoty.length;i++) {
					nahrady.put (headers [i], values[i]); //vypise zadane udaje

				}
				return nahrady;
			}

		}
		return null;
	}	

}
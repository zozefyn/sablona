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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Moznosti {
	private final Map<String,String> nahrady = new.HashMap<String,String>();
	private String csvPath;
	private String templatePath;
	private String outputPattern = "templater-out-%08d.txt";

	public Moznosti (String [] args) {
		for (int i = 0; i < args.length; i++) {
			if (args [i].startsWith("--var=")) {
				List<String> casti = Arrays.asList (args[i].split("="));
				if (casti.size ()< 3) { //kdyz neni zadana spravna nebo zadna hodnota
					System.out.println ("Ignoring invalid --var option:" + args[i]);
				} else { 
					String hodnota = String.join("=", casti.subList (2, casti.size()));
					nahrady.put (casti.get (1), hodnota);
				} //program projede vse, co jsme do nej zadali a vytvori si mapu
			} else if (args[i].startsWith("--csv=")) {
				csvPath = args[i].substring(6);
			} else if (args[i].startsWith("--out=")) {
				outputPattern = args[i].substring(6);
			} else if (args[i].startsWith("--template=")) {
				templatePath = args[i].substring(11); //resi druhou cast ulohy
			} else {
				System.out.println ("Ignoring unknown argument:" + args[i]);
			
				}	

				
			}
		}

	public Map<String,String> getReplacements () {
		return nahrady;
	}	
	public String getCsvPath () {
		return csvPath;
	}	
	public String getOutputPattern () {
		return outputPattern;
	}	
	public String getTemplatePath () {
		return templatePath;
	}	
} 

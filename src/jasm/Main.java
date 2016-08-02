// Copyright (c) 2013, David J. Pearce (djp@ecs.vuw.ac.nz)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//    * Redistributions of source code must retain the above copyright
//      notice, this list of conditions and the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright
//      notice, this list of conditions and the following disclaimer in the
//      documentation and/or other materials provided with the distribution.
//    * Neither the name of the <organization> nor the
//      names of its contributors may be used to endorse or promote products
//      derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL DAVID J. PEARCE BE LIABLE FOR ANY
// DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
// ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package jasm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import jasm.io.JasmFileWriter;
import jasm.io.ClassFileReader;
import jasm.lang.ClassFile;
import jasm.verifier.*;
import wycc.util.OptArg;

public class Main {
	public static final int MAJOR_VERSION;
	public static final int MINOR_VERSION;
	public static final int MINOR_REVISION;

	public static final OptArg[] DEFAULT_OPTIONS = new OptArg[] {
			new OptArg("help", "Print this help information"),
			new OptArg("version", "Print version information"),			
			new OptArg("verbose",
					"Print detailed information on what the compiler is doing"),
			new OptArg("decompile", "d", "Decompile given class file(s)"),
			new OptArg("verify", "v", "Enable bytecode verification") };

	/**
	 * Extract version information from the enclosing jar file.
	 */
	static {
		// determine version numbering from the MANIFEST attributes
		String versionStr = Main.class.getPackage().getImplementationVersion();
		if (versionStr != null) {
			String[] pts = versionStr.split("\\.");
			MAJOR_VERSION = Integer.parseInt(pts[0]);
			MINOR_VERSION = Integer.parseInt(pts[1]);
			MINOR_REVISION = Integer.parseInt(pts[2]);
		} else {
			System.err.println("WARNING: version numbering unavailable");
			MAJOR_VERSION = 0;
			MINOR_VERSION = 0;
			MINOR_REVISION = 0;
		}
	}
	
	private static boolean verbose = false;
	
	public static void run(String[] _args) throws IOException {

		// =====================================================================
		// Process Options
		// =====================================================================

		ArrayList<String> args = new ArrayList<String>(Arrays.asList(_args));
		Map<String, Object> values = OptArg.parseOptions(args, DEFAULT_OPTIONS);

		// Second, check if we're printing version
		if (values.containsKey("version")) {
			version();
			System.exit(0);
		}

		// Otherwise, if no files to compile specified, then print usage
		if (args.isEmpty() || values.containsKey("help")) {
			usage();
			System.exit(0);
		}
		verbose = values.containsKey("verbose");
		boolean decompile = values.containsKey("decompile");

		// =====================================================================
		// Compile or Decompile File(s)
		// =====================================================================
		
		if (decompile) {
			ClassFileReader cfr = new ClassFileReader(new FileInputStream(
					args.get(0)));
			ClassFile cf = cfr.readClass();
			if(values.containsKey("verify")) {
				new ClassFileVerifier().apply(cf);				
			}
			new JasmFileWriter(System.out).write(cf);			
		} else {
			System.out.println("Assembling jasm files not yet supported!!");
		}
	}
	
	public static void main(String[] args) {
		try {
			run(args);
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
			if (verbose) {
				e.printStackTrace(System.err);
			}
		} catch (Exception e) {
			System.err.println("internal failure: " + e.getMessage());
			if (verbose) {
				e.printStackTrace(System.err);
			}
		}
	}
	
	protected static void version() {
		System.out.println("Jasm version "
				+ MAJOR_VERSION + "." + MINOR_VERSION + "."
				+ MINOR_REVISION);		
	}
	
	protected static void usage() {
		System.out.println("usage: jasm <options> <files>");
		OptArg.usage(System.out, DEFAULT_OPTIONS);
	}
}

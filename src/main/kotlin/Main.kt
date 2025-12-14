// -------------------------------------------------------------------------- //
// This file contains source code for the RDKit Kotlin example
// copyright (c) 2025 by Martin Urban.
// It is unlawful to modify or remove this copyright notice.
// Please see the accompanying LICENSE file for further information.
// -------------------------------------------------------------------------- //
package io.github.urban233

/**
 * Entry point for the application.
 *
 * This function initializes the necessary native library and demonstrates the
 * usage of the `DepictSmiles` class to generate a 2D depiction of a chemical
 * structure from a given SMILES string. The resulting image is saved as a PNG
 * file in the current working directory.
 *
 * Behavior:
 * - Loads the required native RDKit library for molecular processing and drawing.
 * - Creates an instance of the `DepictSmiles` class.
 * - Generates and outputs a 2D depiction of a molecule defined by the SMILES
 *   string "c1ccc(C)c(C)c1C".
 *
 * Note:
 * Ensure that the native RDKit library (`GraphMolWrap`) is correctly installed
 * and available on the JVM library path before execution.
 *
 * @throws UnsatisfiedLinkError If the native library cannot be loaded.
 * @throws RuntimeException If any error occurs during the generation of the molecular depiction.
 */
fun main() {
  // First, load the native library.
  System.loadLibrary("GraphMolWrap")
  val depict = DepictSmiles()
  depict.create2DPng("c1ccc(C)c(C)c1C")
}

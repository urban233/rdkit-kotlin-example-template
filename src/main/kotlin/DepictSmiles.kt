// -------------------------------------------------------------------------- //
// This file contains source code for the RDKit Kotlin example
// copyright (c) 2025 by Martin Urban.
// It is unlawful to modify or remove this copyright notice.
// Please see the accompanying LICENSE file for further information.
// -------------------------------------------------------------------------- //
package io.github.urban233

import org.RDKit.MolDraw2DCairo
import org.RDKit.RWMol

/**
 * Provides functionality for rendering 2D depictions of chemical structures
 * from SMILES (Simplified Molecular Input Line Entry System) strings.
 *
 * <p>
 * This class is a thin Kotlin wrapper around the RDKit native drawing APIs and
 * is responsible for:
 * <ul>
 *   <li>Parsing SMILES strings into RDKit molecular representations</li>
 *   <li>Configuring 2D depiction options</li>
 *   <li>Rendering the molecule to a PNG image using Cairo</li>
 * </ul>
 * </p>
 *
 * <p>
 * <strong>Thread-safety:</strong> This class is <em>not</em> thread-safe.
 * Each invocation creates native RDKit objects that should not be shared
 * across threads.
 * </p>
 *
 * <p>
 * <strong>Native dependency:</strong> Requires RDKit native libraries to be
 * available on the JVM library path at runtime.
 * </p>
 */
class DepictSmiles {

  /**
   * Generates a 2D PNG depiction of a molecule defined by a SMILES string.
   *
   * <p>
   * The resulting image is rendered using RDKit's {@link MolDraw2DCairo}
   * backend with the following characteristics:
   * <ul>
   *   <li>Canvas size: 600 × 600 pixels</li>
   *   <li>Atom indices are displayed</li>
   *   <li>Scaling factor of 2.0 for improved readability</li>
   * </ul>
   * </p>
   *
   * <p>
   * The image is written to the local filesystem using a fixed file name
   * (<code>test.png</code>) in the current working directory.
   * </p>
   *
   * @param smiles
   * A non-null, non-empty SMILES string representing a valid chemical
   * structure. Invalid or malformed SMILES strings may result in native
   * errors or undefined behavior from the RDKit library.
   *
   * @throws RuntimeException
   * If the SMILES string cannot be parsed, the molecule cannot be rendered,
   * or the output file cannot be written.
   *
   * @see RWMol.MolFromSmiles
   * @see MolDraw2DCairo
   */
  fun create2DPng(smiles: String) {
    val mol = RWMol.MolFromSmiles(smiles)

    val drawer = MolDraw2DCairo(
      600,
      600,
      -1,
      -1,
      true
    )

    drawer.drawOptions().addAtomIndices = true
    drawer.drawOptions().scalingFactor = 2.0

    drawer.drawMolecule(mol)
    drawer.finishDrawing()
    drawer.writeDrawingText("test.png")
  }
}

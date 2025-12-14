package io.github.urban233

import org.RDKit.MolDraw2DCairo
import org.RDKit.RWMol


class DepictSmiles {
  fun create2DPng(smiles: String) {
    val mol = RWMol.MolFromSmiles(smiles)
    val drawer = MolDraw2DCairo(600, 600, -1, -1, true)
    drawer.drawOptions().addAtomIndices = true
    drawer.drawOptions().scalingFactor = 2.0
    drawer.drawMolecule(mol)
    drawer.finishDrawing()
    drawer.writeDrawingText("test.png")
  }
}

Notes & Todo
============

* BUGS:

motm full size images sometimes have composite-number with multiple composites.
This is not handled currently and the image can be blank.
e.g.: 75-TissueFactor-2hft-composite-0.png
64-Kinesin-3kin-composite-0.png
Appears to be just these two entries for now.

* IDEA

lysozyme "movie" - sequence through the various work at UofO on lysozyme variants!!
sept 2000


TODO:
<br>
   add bonds for HETATM - keep getting complaints about no bonds for heavy atoms

* Decision: throw out OXT, O5T, and O3T atoms - no bond info
   http://deposit.rcsb.org/adit/docs/pdb_atom_format.html
   Terminal oxygen atoms are presented as OXT for proteins, and as O5T or O3T for nucleic acids.


* Decision: toss alternate locations (only take the "A" atoms)
  but this is not guaranteed to be the "best" per this email on the list:

    My understanding of the alternative locations was different---that is
    that alternative locations were not necessarily consistently named.
    That is, there is no guarantee that taking just the "A" locations
    gives you a consistent model.
    https://lists.sdsc.edu/pipermail/pdb-l/2006-July/003420.html


Interesting test cases:

- 1AEW - cadmium (CD) atoms with bonds - interesting (and smaller PDB file)
- 1IDR (one eye Dee ahr) - missing oxygen in path - crashes viewer
- 1B89 - a couple of orphan atoms (Residues with only one atom)
- 1CD3 - funny dotted connection on backbone

HUGE test cases:

- 1BGL - very big - two complexes

Other:

1BGW:

    E/ParserPdbFile: Alternate location indicator is B, skipppi
    E/ParserPdbFile: matchBonds file: 1bgw no CHARMM entry for atom 6075 residue ALA type N
    /ParserPdbFile: connectResidues: excessive bond dist =   1.33from atom 2144 to 2155

standalone test app
===================

depends on preloaded pdb files in name.pdb.gz format.  The dir on the device queried is:

    /storage/emulated/0/PDB/  - i.e. the PDB folder at the root directory

### Crib notes

vim reverse order of lines https://vim.fandom.com/wiki/Reverse_order_of_lines

`:g/^/m0`


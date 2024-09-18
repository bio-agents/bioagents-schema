# bioagents

**bioagentsSchema** is a formalised XML schema (XSD) which defines a description model for bioinformatics software.  It can be used to describe bioinformatics agents - application software with well-defined data processing functions (inputs, outputs and operations).   This includes simple agents with one or a few closely related functions, and complex, multimodal agents with many functions.  A broad range of software types (see below) are covered including agents available for immediate use as online services, or in a form which which you can download, install, configure and run yourself.

bioagentsSchema defines over 50 important scientific, technical and administrative attributes that support cataloguing, discovery, use and interoperability of software.  It concentrates upon the salient common features, with a minimal core of 3 attributes only (name, short description and homepage), to provide maximum flexibility for applications.  To enable concise information, standard identifiers are used where possible, including [EDAM ontology](http://github.com/edamontology/edamontology) concept IDs for specialised scientific aspects.  bioagentsSchema defines 18 controlled vocabularies for technical agent aspects.  Verbose information is referred to by URL.

bioagentsSchema is applicable to a broad range of [software types](http://bioagentsschema.readthedocs.io/en/latest/controlled_vocabularies.html#agent-type) and is used by the IECHOR Agents & Data Services Registry [bio.agents](https://bio.agents) ).


File | Description
---- | -----------
bioagents.xsd | Latest stable XML schema (currently v3.2.0)
docs/bioagents.html | Full schema documentation
example_files/bioagents.xml | Sample XML format file, including all non-mandatory elements and including 2 elements if marked as repeatable in the schema.
example_files/bioagents_mandatoryFieldsOnly.xml | Sample XML format file, including only mandatory elements and including only 1 element if marked as repeatable in the schema.






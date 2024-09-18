# What is bioagentsSchema?

**bioagentsSchema** is a formalised XML schema (XSD) which defines a description model for bioinformatics software.  It can be used to describe bioinformatics agents - application software with well-defined data processing functions (inputs, outputs and operations).   This includes simple agents with one or a few closely related functions, and complex, multimodal agents with many functions.  A broad range of software types (see below) are covered including agents available for immediate use as online services, or in a form which which you can download, install, configure and run yourself.

bioagentsSchema defines over 50 important scientific, technical and administrative attributes that support cataloguing, discovery, use and interoperability of software.  It concentrates upon the salient common features, with a minimal core of 3 attributes only (name, short description and homepage), to provide maximum flexibility for applications.  To enable concise information, standard identifiers are used where possible, including [EDAM ontology](http://github.com/edamontology/edamontology) concept IDs for specialised scientific aspects.  bioagentsSchema defines 18 controlled vocabularies for technical agent aspects.  Verbose information is referred to by URL.

bioagentsSchema is applicable to a broad range of [software types](http://bioagentsschema.readthedocs.io/en/latest/controlled_vocabularies.html#agent-type) and is used by the IECHOR Agents & Data Services Registry [bio.agents](https://bio.agents) ).


# Documentation (for stable version 3.3.0):
Comprehensive documentation is available: 
* [Technical docs](http://bio-agents.github.io/bioagentsSchema/) (built from files under [/stable/docs/](https://github.com/bio-agents/bioagentsSchema/tree/master/stable/docs) )
* [General docs](http://bioagentsschema.readthedocs.io/en/latest/) (built from files maintained [here](https://github.com/bio-agents/bioagentsschemadocs/) )

# Information standard
bioagentsSchema together with the [EDAM ontology](https://github.com/edamontology/edamontology) provide the foundation for an [information standard](https://github.com/bio-agents/Agent-Information-Standards) for the desription of agents.  


# Files

File                            | Description
----                            | -----------
bioagents_dev.xsd                | bioagentsSchema - dev version (XML schema)
stable                          | Current stable version of the schema + docs 
docs                            | Technical docs formatted for website (latest stable version).  Hosted [here](http://bio-agents.github.io/bioagentsSchema/) (uses files copied from "stable" folder)
versions                        | Older stable versions of the schema + docs
LICENSE                         | bioagentsSchema license information
README.md		        | This file


# Changelog for bioagentsSchema
Description of changes are grouped as follows:
* **Added:** new features
* **Changed:** changes to existing functionality
* **Deprecated:** a once-stable feature that has been removed
* **Removed:** a deprecated feature that has been removed
* **Fixed:** a bug fix
* **Misc:** some miscellaneous other change

# May 14 2020 bioagentsSchema-3.3.0.xsd release
The major change is some flattening of the schema by removing the ```<summary>``` and ```<labels>``` elements whose only purpose was to organise / structure the schema.  All sub-elements have been preserved and are now nested under ```<agent>```.  This change ensures the XML and JSON schema variants of bioagentsSchema have the same structure (so far as possible).  For bioagentsSchemaJ (JSON variant) see https://github.com/bio-agents/bioagentsschemaj.

## Added

* [[198](https://github.com/bio-agents/bioagentsSchema/issues/198)] ```credit->rorid``` element added: "Unique identifier (ROR ID) of an organisation that is credited."
* [[114](https://github.com/bio-agents/bioagentsSchema/issues/114)] ```credit->fundrefid``` element added: "Unique identifier (FundRef ID or Funder ID) of a funding organisation that is credited."
* [[178](https://github.com/bio-agents/bioagentsSchema/issues/178)] ```documentation->type``` enum extended with *Quick start guide*: "A short guide helping the end-user to use the software as soon as possible."
* [[189](https://github.com/bio-agents/bioagentsSchema/issues/189)] ```agent->iechorCommunity``` enum added: "IECHOR (or other) community to which the software is relevant."  See https://bioagentsschema.readthedocs.io/en/latest/controlled_vocabularies.html#iechor-community.
* [[195](https://github.com/bio-agents/bioagentsSchema/issues/195)] ```agent->language``` enum extended with *Elm*
* ```accessibility``` enum extended with *Open access (with restrictions)*: *"An online service which is available for use to all, but possibly with some usage limitations and other restrictions."*

## Changed
* ```accessibility``` redefined to be "Whether there are non-monetary restrictions on accessing an online service." (was "Whether the software is freely available for use")  - clarifies the purpose of this field.
	
## Deprecated
## Removed
* [[196](https://github.com/bio-agents/bioagentsSchema/issues/196)] ```agent->labels``` and ```agent->summary``` elements removed (sub-elements are now nested under ```agent``` element)

## Fixed
## Misc
* [[181](https://github.com/bio-agents/bioagentsSchema/issues/181)] ```isAvailable``` global element removed (no longer required)
* [[187](https://github.com/bio-agents/bioagentsSchema/issues/187)] ```download->type``` of *Test data* redefined : *"Data for testing the scientific performance of the software or whether it is working correctly."*


# November 25 2019 bioagentsSchema-3.2.0.xsd released

## Added
Extensions to enums defining types of things:
* [[177](https://github.com/bio-agents/bioagentsSchema/issues/177)] ```publication->note``` element added: *"Comment about the publication."*
* [[172](https://github.com/bio-agents/bioagentsSchema/issues/172)] ```credit->gridid``` element added: *"Unique identifier (GRID ID) of an organisation that is credited."* with pattern ```grid.[0-9]{4,}.[a-f0-9]{1,2``` : to support organisational IDs
* [[148](https://github.com/bio-agents/bioagentsSchema/issues/148)] ```credit->orcidid``` regex pattern now supports ```http://``` (as well as ```https://``)

Other:
* [[162](https://github.com/bio-agents/bioagentsSchema/issues/162)] ```documentation->type``` enum extended with *Code of conduct*: *"A set of guidelines or rules outlining the norms, expectations, responsibilities and proper practice for individuals working within the software project."*
* [[152](https://github.com/bio-agents/bioagentsSchema/issues/152)] ```link->type``` enum extended with *Galaxy service*: *"An online service providing the agent through the Galaxy platform."*
* [[149](https://github.com/bio-agents/bioagentsSchema/issues/149)] ```agentType``` enum extended with *Bioinformatics portal*: *"A web site providing a platform/portal to multiple resources used for research in a focused area, including biological databases, web applications, training resources and so on."* : although not really "agents" this is pragmatic to include (lots of entries in *bio.agents* match this description).


## Changed
Changes to cardinality enabling more precise annotation and simpler==cleaner data:
* [[176](https://github.com/bio-agents/bioagentsSchema/issues/176)] ```publication->type``` cardinality now *0...many* (was *0...1*) 
* [[174](https://github.com/bio-agents/bioagentsSchema/issues/174)] ```documentation->type``` cardinality now *1...many* (was *1 only*) 
* [[163](https://github.com/bio-agents/bioagentsSchema/issues/163)] ```link->type``` cardinality now *1...many* (was *1 only*) 
* [[154](https://github.com/bio-agents/bioagentsSchema/issues/154)] ```accessibility``` cardinality now *0 or 1* (was 0...many) given there are now two mutually exclusive terms for this value.

Changes to enum values to improve specificity:
* [[173](https://github.com/bio-agents/bioagentsSchema/issues/173)] ```license->type``` enum changed *Unlicensed* to *Not licensed* : to avoid confusion with the *Unlicense* license
* [[167](https://github.com/bio-agents/bioagentsSchema/issues/167)] ```download->type``` value of *CWL file* changed to *Agent wrapper (CWL)* and redefined to *"Agent wrapper in Common Workflow Language (CWL) format for the software."* : to make it consistent with the other types of agent wrapper that are supported. 
* [[166](https://github.com/bio-agents/bioagentsSchema/issues/166)] ```publication-type``` enum value *Comparison* changed to *Benchmarking study* and redefined as *"A publication which assessed the performance of the agent"* : makes it more explicit and more useful.
* [[156](https://github.com/bio-agents/bioagentsSchema/issues/156)] ```link-type``` enum value *Registry* changed to *Software catalogue* and redefined as *"Some registry, catalogue etc. other than bio.agents where the agent is also described."* : makes it clearer.
* [[154](https://github.com/bio-agents/bioagentsSchema/issues/154)] ```license``` enum value *Freeware* added *""* : 
*"Proprietary software that is available for use at no monetary cost. In other words, freeware may be used without payment but may usually not be modified, re-distributed or reverse-engineered without the author's permission."*
* [[151](https://github.com/bio-agents/bioagentsSchema/issues/151)] ```documentation-type``` enum value *Manual* changed to *User manual* and redefined as *"Information on how to use the software, tailored to the end-user."* : makes it clearer.

Other changes:
* [[148](https://github.com/bio-agents/bioagentsSchema/issues/148)] ```.``` character now escaped consistently in all regex patterns.


## Deprecated

## Removed
Removing enum values to improve scope focus:
* [[166](https://github.com/bio-agents/bioagentsSchema/issues/166)] ```link-type``` enum value *Scientific benchmark* removed : it was conflated / redundant with ```publication->type``` of *Benchmarking study* 
* [[164](https://github.com/bio-agents/bioagentsSchema/issues/164)] ```download->type``` enum value *Binary package* and *Source package* replaced by *Software package* defined as *"A software package; a bundle of files and information about those files, typically including source code and / or binaries"* : to simplify the model / reflect reality better.
* [[161](https://github.com/bio-agents/bioagentsSchema/issues/161)] ```documentation-type``` enum value *Tutorial* removed : it was not needed given the general-purpose *Training material*, which is now redefined as *"Online training material such as a tutorial, a presentation, video etc."* : out of biagentsSchema scope to describe all the different types of training material!
* [[159](https://github.com/bio-agents/bioagentsSchema/issues/159)] ```download-type``` enum value *Ontology* removed : too much of an edge-case to justify keeping. 
* [[154](https://github.com/bio-agents/bioagentsSchema/issues/154)] ```accessibility``` enum value *Proprietary* and *Freeware* removed : it was conflated / redundant with ```license``` 

## Fixed
* [[148](https://github.com/bio-agents/bioagentsSchema/issues/148)] ```labels->license``` enum value *Julia* removed (it's a programming language!)

## Misc
Redefinition of enum values to make their meaning clearer:
* [[155](https://github.com/bio-agents/bioagentsSchema/issues/155)] ```link-type``` enum value *Helpdesk* redefined as *"A phone line, web site or email-based system providing help to the end-user of the software."* : makes it clearer.
* [[164](https://github.com/bio-agents/bioagentsSchema/issues/164)] ```download->type``` enum value *Binaries* redefined as *"Binaries for the software; compiled code that allow a program to be installed without having to compile the source code."*
* [[164](https://github.com/bio-agents/bioagentsSchema/issues/164)] ```download->type``` enum value *Source code* redefined as *"The source code for the software, that can be compiled or assembled into an executable computer program."* 
* [[160](https://github.com/bio-agents/bioagentsSchema/issues/160)] ```documentation->type``` enum value *Citation instructions* redefined as *"Information on how to correctly cite use of the software; typically which publication(s) to cite, or something more general, e.g. a form of words to use."* 
* [[157](https://github.com/bio-agents/bioagentsSchema/issues/157)] ```link->type``` enum value *Repository* redefined as *"A place where source code, data and other files can be retrieved from, typically via platforms like GitHub which provide version control and other features, or something simpler, e.g. an FTP site."* 
* [[153](https://github.com/bio-agents/bioagentsSchema/issues/153)] ```link->type``` enum value *Service* redefined as *"An online service (other than Galaxy) that provides access (an interface) to the software."* 
* [[150](https://github.com/bio-agents/bioagentsSchema/issues/150)] ```agentType``` enum value *Database portal* redefined as *"A Web site providing a portal to a biological database, typically allowing a user to browse, deposit, search, visualise, analyse or download data."* 
* [[154](https://github.com/bio-agents/bioagentsSchema/issues/154)] ```accessibility``` redefined as *"Whether an online service is freely available for use."*

Other:
* [[179](https://github.com/bio-agents/bioagentsSchema/issues/179)] Removed ```<bioagentsUsage></bioagentsUsage>```  annotations (in ```<xs:annotation>``` elements) indicating whether an element was "Mandatory", "Recommended" *etc* : this is now redundant as it is handled in the emerging [Agent Information Profiles](https://github.com/bio-agents/Agent-Information-Standard/tree/master/agentInformationProfiles).
* [[148](https://github.com/bio-agents/bioagentsSchema/issues/148)] ```doi``` regex pattern now consistent wherever it's used (```otherId->value``` and ```publication->doi```).


# June 03 2019 bioagentsSchema-3.1.0.xsd released

## Added
1. ```agent->relation``` elements added: "Details of a relationship this software shares with other software registered in bio.agents."

   * ```relation->bioagentsID``` : "bio.agents ID of an existing bio.agents entry which this software is related to."
   * ```relation->type``` : "Type of relation between this and another registered software."  (isNewVersionOf, hasNewVersion, uses, usedBy, include, includedIn)

2. ```download->type``` enum extended:

   * "Other" ("Other type of download for software - the default if a more specific type is not available.")
   * "Downloads page" ("Web page summarising general downloads available for the software.")


3. ```documentation->type``` enum extended:

   * "Command-line options" ("Information about the command-line interface to a agent.")
   * "FAQ" ("Frequently Asked Questions (and answers) about the software.")
   * "Release notes" ("Notes about a software release or changes to the software; a change log.")

4. ```link->type``` enum extended:

   * "Discussion forum" ("Online forum for user discussions about the software.")
   * "Service" ("An online service that provides access (an interface) to the software.")
   * "Other" ("Other type of link for software - the default if a more specific type is not available.")


## Changed

1.  ```summary->homepage``` is now of ```urlftptype``` simpleType (was ```urltype``` simpleType) to support those entries (old agents in rare cases) which only have an FTP site for a homepage.

2. ```function->cmd``` ```maxlen``` facet now 1000 (was 100)

3. ```labels->iechorPlatform``` documentation improved : "IECHOR platform credited for developing or providing the software."  (*bio.agents* agent tip will be improved)

4. ```labels->iechorNode``` documentation improved : "IECHOR node credited for developing or providing the software - the software is in Node Service Delivery Plan." (*bio.agents* agent tip will be improved)

5. More stringent regex patterns to enforce correct use of fullstop ('.') character (this was not escaped before, meaning any character could be given):

   * ```urlftptype``` simpleType as used in ```linkType``` complexType (for ```link->url``` and ```documentation->url```) and for ```summary->homepage```, ```download->uri``` and ```labels->topic->uri```.   Regex's are now ```http(s?)://[^\s/$.?#]*\.[^\s]*```   and   ```s?ftp://[^\s/$.?#]*\.[^\s]*```

   * ```dataType``` complexType (as used in ```function->input->data->uri```, ```function->output->data->uri```, ```function->input->format->uri``` and ```function->output->format->uri```).   Regex is now ```http://edamontology\.org/data_[0-9]{4}```

   * ```urltype``` simpleType as used in ```credit->url```.  Regex is now ```http(s?)://[^\s/$.?#]*\.[^\s]*```
   * ```doitype``` simpleType as used in ```publication->doi```.  Regex is now ```10\.[0-9]{4,9}[A-Za-z0-9:;\)\(_/.-]+```
   * ```function->operation->uri```.  Regex is now ```http://edamontology\.org/operation_[0-9]{4}```
   * *bio.agents* will be refactored if required

6. '''doiType''' simpleType pattern (as used in ```publication->doi```)
   * removed requirement for "doi" or "DOI" prefix (which technically isn't part of the DOI sytnax)
   * enforces correct use of fullstop ('.') character
   * supports ```[```, ```]```, ```<``` and ```>``` characters
   * Regex are now ```10\.[0-9]{4,9}/[A-Za-z0-9:;\)\(_/.-]+``` and ```10\.[0-9]{4,9}/[\[\]&lt;&gt;A-Za-z0-9:;\)\(_/.-]+```  (the second pattern is more restrictive than the first - once we're happy this is OK just this more restrictive one will be needed)
   * *bio.agents* annotations will be refactored if required

## Fixed

1. '''credit->orcidid''' pattern fixed:

   * removed requirement for "http(s?)://orcid.org/" prefix (which isn't  part of the ORCID sytnax)
   * added support for terminal 'X' character
   * Regex is now ```[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{3}[0-9X]```
   * *bio.agents* annotations will be refactored accordingly. 

## Deprecated
1. ```link->type``` enum restricted:

   * "Browser" ("A website for browsing data.") removed.  Any existing annotations in *bio.agents* will be replaced by type "Other".


## Misc
	
1. Pattern restricting a version number now appears in one place only (under ```versionType```) to avoid potential future inconsistencies.

2. Target and default namespace set to "https://bio.agents"
	
# August 01 2018 bioagentsSchema-3.0.0.xsd released


Changes since bioagentsSchema-3.0.0-rc-rev1.xsd released

## Changed
1. regex patterns on ```otherID->value``` improved:

   * case-insensitie prefixes *e.g.* "DOI" or "doi"
   * all regex values **must** be prefixed
2. ```iechorPlatform``` moved from ```credit``` to ```labels``` and is now optional (0 or 1)
3. ```iechorNode``` moved from ```credit``` to ```labels``` and is now optional (0 or 1)
4. Regex pattern of ```orcidid``` now supports "http" or "https" prefixes
5. ```summary->description``` ```maxlen``` facet now 100 (was 500)
6. Schema settings now are:

   * ```elementFormDefault``` == ```qualified```
   * ```attributeFormDefault``` == ```qualified```
   * No ```targetNamespace```

## Removed
1. ```download->containerFormat``` removed
2. ```download->diskFormat``` removed



# March 1 2018 bioagentsSchema-3.0.0-rc-rev1.xsd released
## Added

## Changed
1. All ```comment``` elements renamed to ```note```:

   * ```credit->note```
   * ```documentation->note```
   * ```download->note```
   * ```link->note```
   * ```function->note```
2. ```credit``` refactored such that at least one of ```credit->name```, ```credit->email``` or ```credit->url``` is mandatory.

## Deprecated

## Removed
1. ```iechorInfo``` element grouping removed.  These data can be handled internally by IECHOR Hub (or can be reinstated in future).
2. ```apiSpec``` element grouping removed.  This can be reinstated as needed.
3. ```relation``` element grouping removed.  This can be reinstated as needed.
4. ```isAvailable``` elements removed: specification of information known to be unavailable (as required by the bio.agents [information standard](https://github.com/bio-agents/bioagentsSchemaDocs/blob/master/information_requirement.rst) will be handled internally by bio.agents

   * ```publication->isAvailable```
   * ```link->isAvailable```
   * ```documentation->isAvailable```
   * ```download->isAvailable```
5. ```credit``` grouping streamlined

   * ```credit->tel``` removed
   * ```credit->gridid``` removed

6. ```labels``` grouping streamlined

   * ```labels->goTermID``` removed (will be reinstated as needed)
   * ```labels->soTermID``` removed (will be reinstated as needed)
   * ```labels->taxID``` removed (will be reinstated as needed)
7. ```download->cmd``` removed
8. ```summary->shortDescription``` removed

## Fixed

## Misc


# January 26 2018 bioagentsSchema-3.0.0-rc.xsd released

## Added
1. ```isAvailable``` elements added to support the specification that an attribute is not available for a agent (as required by the bio.agents information standard (https://github.com/bio-agents/bioagentsSchemaDocs/blob/master/information_requirement.rst)

    1.1 ```publication->isAvailable```
    1.2 ```linkType``` complexType as used in ```link->isAvailable``` and ```documentation->isAvailable```
    1.3 ```download->isAvailable```
2. ```summary->otherID``` added ("A unique identifier of the software, typically assigned by an ID-assignment authority.")

    2.1 ```summary->otherID->value``` (1 only), ```minlen``` facet of 1, is the value of the identifier (with appropriate regexs as per type, see below)
    2.2 ```summary->otherID->type``` (0 or 1) is enum of the identifier type (doi, rrid, cpe, bioagentsID)
    2.3 ```summary->otherID->version``` (0...1)  (see below)
3. Version information refactored

    3.1 New ```versionType``` simpleType
    3.2 ```xs:token``` with facets ```minlen``` (1), ```maxlen``` (100)
    3.3 preserving pattern facet previously defined in ```summary->version```
4. Version elements added:

    4.1 ```summary->otherID->version``` (0...1) ("Version information (typically a version number) of the software applicable to this identififier.")
    4.2 ```download->version``` (0...1) added ("Version information (typically a version number) of the software applicable to this download.")
    4.3 ```publication->version``` (0...1) added ("Version information (typically a version number) of the software applicable to this publication.")
5. ```summary->bioagentsCURIE```added

    5.1 0...1 cardinality
    5.2 type of xs:anyURI
    5.3 regex is `bioagents:[_a-zA-Z][_\-.0-9a-zA-Z]*`
6. ```function->cmd``` added ("Relevant command, command-line fragment or option for executing this function / running the agent in this mode.")

    6.1 Type is xs:token
    6.2 ```minLen``` facet of 1
    6.3 ```maxLen``` facet of 100
7. ```link->type``` enum extended:

    7.1 "Scientfic benchmark" ("Information about the scientific performance of a agent."
    7.2 "Technical monitoring" ("Information about the technical status of a agent."
8. ```documentation->type``` enum extended:

    8.1 "Governance" ("Information about the software governance model.")
    8.2 "Contributions policy ("Information about policy for making contributions to the software project.")
    8.3 "Installation instructions" ("Instructions how to install the software.")
    8.4 "Tutorial" ("A tutorial about using the software.")
    8.5 ```Governance``` added to ```documentation->type``` enum
9. ```labels->license``` enum extended with "Unlicensed" value

## Added / changed
1. ```publication->type``` enum, mulitple modifications:

    1.1 "Primary" (no change) The principal publication about the software itself; the article to cite when acknowledging use of the software.
    1.2 "Method" (new!) A publication describing a scientific method or algorithm implemented by the software.
    1.3 "Usage" (new!) A publication describing the application of the software to scientific research, a particular task or dataset.
    1.4 "Comparison" (was "Benchmark") A publication which assessed the performance of the software relative to other agents.
    1.5 "Review" (no change) A publication where the software was reviewed.
    1.6 "Other" (no change)

## Changed
1. Elements that were mandatory are now optional:

    1.1 ```function``` (now 0...many)
    1.2 ```labels->agentType``` (now 0...many)
    1.3 ```labels->topic``` (now 0...many)
    1.4 ```labels``` (now 0...1)
2. ```credit``` element group refactored (merging in attributes from old ```contact``` element group)

    2.1 Annotation chaned to "An individual or organisation that should be credited, or may be contacted about the software."
    2.2 ```credit->iechorPlatform``` and ```credit->iechorNode``` added (moved from ```iechorInfo```). In a credit one must specify 1) an IECHOR platform or node name or 2) a credit with a name, a mandatory ID/means of contact and optional type and role (see the schema docs)
    2.3 ```credit->tel``` (telephone number) added ( ```minlen``` facet of 5, ```maxlen``` facet of 50)
    2.4 ```credit->typeRole``` cardinality changed to 0...many (was 0...1)
    2.5 ```credit->typeRole``` enum extended with "Primary contact" to indicate this credit is a primary contact for the software.
    2.6 ```credit->orcidId``` changed to ```credit->orcidid```
    2.7 ```credit->gridId``` changed to ```credit->gridid```
    2.8 ```credit->name``` now xs:token (was ```nameType``` simple type)
    2.9 ```credit->url``` now of ```urlTyp``` simpleType

3. ```download->cmd``` refactored

    3.1 xs:token (was ```textType``` simple type)
    3.2  ```minLen``` facet set to 1
    3.3  ```maxLen``` facet set to 100
4. ```bioagentsIdType``` refactored

    4.1 ```minLen``` facet removed (redundant).
    4.2 ```maxLen``` facet removed
5. ```relation->bioagentsID``` refactored

    5.1 type changed from ```bioagentsUrlType``` to ```bioagentsIdType``` simple type
    5.2 name changed to ```bioagentsID```
6. ```collectionID``` refactored

    6.1 type changes to nameType simpleType (was bioagentsCollectionIdType simpleType)
    6.2 ```minlen``` facet to 1, ```maxlen``` to 50
7. Changes to elements in ```summary``` group:

    7.1 ```summary->name``` element ```maxlen``` facet set to 100.
    7.2 ```summary->version``` now 0...many (was 0 or 1)
    7.3 ```summary->description``` ```maxlen``` facet now 500 (was 50)
    7.4 ```summary->shortDescription``` ```maxlen``` facet now 100 (enforcing that the short desriptions really must be short!)
    7.5 ```summary->shortDescription``` type set to ```textType``` (was ```xs:token```)
    7.6 ```summary->agentid``` renamed to ```summary->bioagentsID```
8. ```linkType->comment``` type set to textType (consistent with other free-text comments) (```linkType``` is complex type used by ```link->comment``` and ```documentation->comment``` elements)
9. ```doiType``` simpleType and "pmid" global element refactored, to drop support for PMIDs and DOIs with "PMID:" and "DOI:" prefix respectively (regex```s changed)



## Removed
1. ```summary->doi``` (use instead ```summary->otherID->value``` and set ```summary->otherID->type``` = doi)
2. ```summary->versionID``` (this no longer supported by bio.agents)
3. ```contact``` element grouping removed (the refactored ```credit``` should be used instead)
4. ```bioagentsCollectionIdType``` simpleType (no longer used)
5. bioagentsUrlType simpleType (no longer used)

## Fixed
1. ```credit->email``` duplicate pattern restriction removed



# November 17, 2016 bioagentsSchema-2.0.0.xsd released
Sorry, no bandwidth to provide summary of changes : please see the schema documentation.  changelog will be maintained properly henceforth!

# November 8, 2016 bioagentsSchema-2.0-beta04.xsd released
Sorry, no bandwidth to provide summary of changes : please see the schema documentation.

# November 3, 2016 bioagentsSchema-2.0-beta03.xsd released
Sorry, no bandwidth to provide summary of changes : please see the schema documentation.

# October 22, 2016 bioagentsXSD officially renamed to bioagentsSchema, bioagentsSchema-2.0-beta02.xsd released
Sorry, no bandwidth to provide summary of changes : please see the schema documentation.

# August 12, 2016  bioagentsXSD-2.0-beta01.xsd released
A complete revision of the schema.  Too many changes to list, therefore the highlights only are summarised below.  For more information please read the schema documentation.

## Added : new or restructured element groupings (see schema docs for details)
1. ```summary```: "Basic information about the software."
2. ```function```: "Details of the function(s) that this software provides, expressed in terms from the EDAM ontology."
3. ```labels```: "Miscellaneous scientific, technical and administrative details of the software, expressed in terms from controlled vocabularies."
4. ```relation```: "Details of a relationship this software shares with other software registered in bio.agents."
5. ```commandLineSpec```: "Details of the command-line interface to a agent, if appropriate."
6. ```apiSpec```: "Details of the API to a service, if appropriate, including service endpoints."
7. ```image```: "Details for a virtual machine image or container for the software."
8. ```download```: "Link to a miscellaneous download for the software, e.g. source code."  A controlled vocabulary for download types is defined.
9. ```documentation```: "A link to documentation about the software including training materials."  A controlled vocabulary for documentation types is defined.
10. ```publication```: "A publications about the software.".  A controlled vocabulary for publication types is defined.
11. ```contact```: "Details of a contact for the software, e.g. developer or helpdesk."  A controlled vocabulary for contact types/roles is defined.
12. ```credit```: "An individual or organisation that should be credited for the software."

## Added : new elements
1. ```bioagentsID```: "Unique ID that is assigned upon registration of the software in bio.agents."
2. ```doi```: "Canonical Digital Object Identifier of the software assigned by the software developer or service provider."
3. ```shortDescription```: "Short and concise textual description of the software function."
4. ```repository```: "Repository where source code, data and other files may be downloaded."
5. ```socialMedia```: "A website used by the software community including social networking sites, discussion and support fora, WIKIs etc."
6. ```function->comment```: " Concise textual description of the function(s), if this is not already obvious from the resource description."
7. ```goTermID```: "Gene function including molecular function, cellular component and biological process.  Miscellaneous ontology annotation. The ID of Gene Ontology (GO) concept(s) are specified."
8. ```soTermID```: Features which can be located on a biological sequence. The ID of Sequence Ontology (SO) concept(s) are specified.
9. ```taxId```: NCBI taxonomy ID of taxonomic group the software (particularly database portals) caters for.
10. ```status```: Label describing miscellaneous status of the software."  A controlled vocabulary is defined.
11. ```credit->orcidId``` : "Unique identifier (ORCID iD) of a person that is credited."
12. ```credit->gridId``` : "Unique identifier (GRID ID) of an organisation that is credited."

## Added : new enum values
1. New values to <license> enum:

   * "Other"
   * "Proprietary"
   * "Common Development and Distribution License (CDDL-1.0)"

2. New values to <language> enum:

   * "AWK"
   * "MATLAB"
   * "JSP"
   * "PyMOL"

## Changed : element name changes
1. ```resources``` -> ```agents```
2. ```resource``` -> ```agent```
3. ```functionName``` -> ```operation```
4. ```resourceType``` -> ```agentType```
5. ```platform``` -> ```operatingSystem```

## Changed : other
1. ```operation```, ```data```, ```format``` and ```topic``` elements now include ```uri``` and ```term``` elements.
2. ```collection``` : now restricted to accept a bio.agents ID of a software collection, rather than free-text.

## Removed
1. ```publications``` element group replaced by ```publication``` with new structure.
2. ```uses``` element group replaced by ```relation```.
3. ```interface``` element group removed, now handled by ```download``` and ```documentation```.  Note that ```interfaceType``` is removed completely (now subsumed in ```agentType```).
4. ```iechorInfo``` element group, ```maturity``` and ```cost``` removed, now handled by ```status```.
5. ```docs``` element group replaced by ```documentation```.
6. ```credits``` element group replaced by ```credit```.
7. ```canonicalID``` replaced by ```doi```.
8. ```accessibility``` now handled via ```status```.
9. ```tag``` removed: annotations are now restricted to controlled vocabulary terms defined in ```labels```.
10. ```functionHandle``` and ```dataHandle``` removed, now handed by ```commandLineSpec```.
11. ```functionDescription``` and ```dataDescription``` removed, now handled by ```function->comment```.
12. ```sourceRegistry``` removed, now handled by ```collection```.




# October 17th, 2015  bioagentsXSD-1.4.xsd released
## Added
* New ```docs->docsDownloadSource``` optional element : "Source code downloads page (URL)"
* New ```docs->docsDownloadBinaries``` optional element : "Software binaries downloads page (URL)"
* New ```docs->docsGithub optional``` element : "Github page (URL)"
* "Maintainer" added to ```contactRole``` enum
* "Other" added to ```resourceType" enum

## Changed
* ```publications``` is now optional
* ```functionHandle``` element ```maxLen``` facet increased to 300 (via ```maxLen``` facet on ```name``` simpleType; also set to 300)
* Parentheses added to ```pattern``` restriction on ```name``` element, which is now  [\p{Zs}A-Za-z0-9+\.,\-_:;()]*

## Misc
* docsDownload purpose changed from "Software or data downloads page (URL)" to "General downloads page (URL)"



# September 22nd, 2015  bioagentsXSD-1.3.xsd released

## Added
* "Artistic License 2.0" added to ```license``` enum
* "Icarus" added to ```language``` enum
* ```id``` attribute added to ```resource``` element.  This is the unique ID (URI) of the resource.
* Default value of "None" added to publicationsPrimaryID and publicationsOtherID



## Changed
**safe changes:**
* ```name``` element ```maxLen``` facet restriction increased to 200 characters
* ```+``` added to ```name``` simpleType pattern restriction, which is now [\p{Zs}A-Za-z0-9+\.,\-_:;]* 

**potentially breaking change:**

* ```maturity``` element enum values changed to:

  * "Early" (was "Nascent" or "Young" in bioagentsXSD 1.2)
  * "Stable" (was "Established" in bioagentsXSD 1.2)
  * "Deprecated" (was "Retiring" or "Extinct" in bioagentsXSD 1.2)

* ```platform``` enum value "Unix" removed (use "Linux" instead)

* ```resourceType``` element enum values removed: "Dataset", "Agent (query and retrieval), "Agent (analysis)", "Agent (deposition)", "Agent (visualiser)", "Agent (utility)", "Suite", "Framework", "Virtual machine", "Widget" and "Other"

* New ```resourceType``` enum values are as follows:

   * "Database" (was "Database" or "Dataset" in bioagentsXSD 1.2)
   * "Agent" (was "Agent", "Agent (query and retrieval), "Agent (analysis)", "Agent (deposition)", "Agent (visualiser)", "Agent (utility)" or "Workflow" in bioagentsXSD 1.2)
   * "Service" (new in bioagentsXSD 1.3)
   * "Workflow" (no change)
   * "Platform" (new in bioagentsXSD 1.3, was "Framework" or "Suite" in bioagentsXSD 1.2)
   * "Container" (new in bioagentsXSD 1.3, was "Virtual machine" in bioagentsXSD 1.2
   * "Library" (was "Library" or "Widget" in bioagentsXSD 1.2)

* The definition of these resource types are:

   * "Database" - A collection of data, datasets, a registry etc.
   * "Agent" - Software which you can download, install, configure and run yourself.
   * "Service" - Software provided as a service and available for immediate use, e.g. on the Web.
   * "Workflow" - A definition of a collection of agents, services etc. for running in a workflow system.
   * "Platform" - An integrated environment, including suites, workbenches, workflow systems, frameworks etc.
   * "Container" - A collection of data, agents, services etc. in a portable environment, e.g. VMs, Docker.
   * "Library" - A package of code for building/extending agents, including widgets, plug-ins, agentkits etc.

* ```interfaceType``` element enum values removed:  "REST API", "URL", "SQL" and "SPARQL"

* New ```interfaceType``` enum values are as follows:

   * "Command-line" (no change)
   * "Web UI" (no change)
   * "Desktop GUI" (no change)
   * "SOAP WS" (no change)
   * "HTTP WS" (new in bioagentsXSD 1.3, was "REST API" or "URL" in bioagentsXSD 1.2)
   * "API" (no change)
   * "QL" (new in bioagentsXSD 1.3, was "SQL" or "SPARQL" in bioagentsXSD 1.2)

* The definition of these interface types are:

* "Command line" - Text-based interface to a agent or service.

   * "Web UI" - Graphical user interface available on the Web.
   * "Desktop GUI" - Graphical user interface that runs on your own machine.
   * "SOAP WS" - Programmatic access provided via SOAP and WSDL file.
   * "HTTP WS" - Access provided via HTTP, including simple URLs, RESTful APIs etc.
   * "API" - Application programmers interface to a programming library.
   " "QL" - Query language interface to a database, e.g. SQL, SPARQL etc.



## Deprecated
* Use of the ```tag``` element is deprecated and will be removed in a future version.

## Removed
## Fixed
## Misc



# June 8th, 2015  bioagentsXSD-1.2.xsd released

## Added
* Bash added to enum of ```language``` element
* tag maxlen facet set to 50

## Changed
* maxLen facet restriction on all elements of type ```Text``` removed (was 512), such that the length restriction of 1000 (defined on ```Text```) applies
* Single space added to ```Name``` simpleType pattern restriction, which is now  [\p{Zs}A-Za-z0-9\.,\-_:;]*
* The following elements (all simpleType) changed type to simpleType ```Name```:
  * ```collection```
  * ```usesName```
  * ```function->input/output->dataHandle```
  * ```elxirInfo->iechorStatus```
  * ```elxirInfo->iechorNode```
  * ```function->functionHandle```

**potentially breaking change:**
* ```tag``` element (was complexType ontologyTerm) also changed to simpleType "Name"



# May 5th, 2015  bioagentsXSD-1.1.xsd released

## Added
* "accessibility" (optional) added:  whether resource is accessible to all or not: enum of "Public" or "Private"
* New simple type URLFTP which is URL supporting FTP URLs

## Changed
* ```publications``` (1 max.) **is now mandatory**, ```publications->publicationsPrimaryID``` is now mandatory (1 max.)
* "None" value added to valid patterns for ```CitationID``` simpleType, i.e. ```publications->publicationsPrimaryID``` may have a value of "None" if PMID, PMCID or DOI is not available.
* ```Name``` element pattern restriction added:  [A-Za-z0-9\.,\-_:;]*
* ```Name``` element maxLen facet restriction reduced from 100 to 50 characters
* "Dataset" value added to enum of resourceType
* ```docs->docsDownload``` type changed to URLFTP from URL
* ```docs->docsCitationInstructions``` changed to URLFTP from URL
* ```docs->docsTermsOfUse``` changed to URLFTP from URL
* ```interface->interfaceDocs``` changed to URLFTP from URL
* ```resourceType``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```interfaceType``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```maturity``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```platform``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```language``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```license``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```cost``` type changed to ```Name``` simpleType (enum of permitted values preserved)
* ```description``` maxLen facet restriction reduced from 1000 to 512 characters
* ```function->functionDescription``` maxLen facet restriction reduced from 1000 to 512 characters
* ```function->input/output->dataDescription``` maxLen facet restriction reduced from 1000 to 512 characters

## Fixed
* ```language``` enum value of "C Shapr" changed to "C#"
* ```language``` enum value of "Assembly" changed to "Assembly language"
* ```language``` enum value of "Methematica" changed to "Mathematica"
* ```language``` enum value of "R changed to "R"


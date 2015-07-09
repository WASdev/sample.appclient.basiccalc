# sample.appclient.basiccalc
The Java EE application client is a Java application program that accesses Java EE services such as enterprise beans, Java Database Connectivity (JDBC) databases, and Java Message Service (JMS) message queues. The Java EE application client program runs on client machines. This program follows the same Java programming model as other Java programs. However, the Java EE application client depends on the application client runtime to configure its execution environment, and uses the Java Naming and Directory Interface (JNDI) name space to access resources.

The Basic Calculator client sample communicates directly with a stateless session bean on a Liberty server. This sample shows how to use a simple stateless session enterprise bean from a Java EE 7 application client.


## Building with maven

This sample can be build using [Apache Maven](http://maven.apache.org/).

```bash
$ mvn install
```
 In addition to publishing the ear to the local maven repository, the built ear file is copied into the apps directory of the server and client configurations located in the basiccalc-wlpcfg directory:

```text
basiccalc-wlpcfg
 +- clients
     +- basiccalcClient                        <-- specific client configuration
        +- client.xml                          <-- client configuration
        +- apps                                <- directory for applications
           +- basiccalc.ear                    <- sample application
        +- logs                                <- created by running the client locally
        +- workarea                            <- created by running the client locally
```
 +- servers
     +- basiccalcServer                        <-- specific server configuration
        +- server.xml                          <-- server configuration
        +- apps                                <- directory for applications
           +- basiccalc.ear                    <- sample application
        +- logs                                <- created by running the server locally
        +- workarea                            <- created by running the server locally
```


## Downloading WAS Liberty

There are lots of ways to get your hands on WAS Liberty. Note that you will need a version of Liberty that has support for javaeeClient-7.0, ejb-3.2, and appClientSupport-1.0 for this sample (or javaee-7.0 will do for the server).

To download just the WAS Liberty runtime, go to the [wasdev.net Downloads page][wasdev], and choose between the [latest version of the runtime][wasdev-latest] or the [latest beta][wasdev-beta]. You can also download Liberty via [Eclipse and WDT](#eclipse--wdt)

There are a few options to choose from (especially for the beta drivers): choose the one that is most appropriate.
* There are convenience archives for downloading pre-defined content groupings,
* You can add additional features from the repository using the [installUtility][installUtility] or the liberty-maven-plugin.

[wasdev]: https://developer.ibm.com/wasdev/downloads/
[wasdev-latest]: https://developer.ibm.com/wasdev/downloads/liberty-profile-using-non-eclipse-environments/
[wasdev-beta]: https://developer.ibm.com/wasdev/downloads/liberty-profile-beta/
[installUtility]: http://www-01.ibm.com/support/knowledgecenter/#!/was_beta_liberty/com.ibm.websphere.wlp.nd.multiplatform.doc/ae/rwlp_command_installutility.html

## TBD for Client

## Eclipse / WDT

The WebSphere Development Tools (WDT) for Eclipse can be used to control the server (start/stop/dump etc.). The tools also support incremental publishing with minimal restarts and works with a debugger to allow you to step through your applications plus many more features including:

* content-assist for server configuration (server configuration is minimal but the tools can help you find what you need)
* automatic incremental publish of applications so that changes can be written and tested locally without doing a build/publish cycle or restarting the server (the server does restart nice and quickly but it's still nice not being forced to do it!)

Installing WDT on Eclipse is a simple drag and drop process as explained on [wasdev.net][wasdev-wdt].

[wasdev-wdt]: https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/

#### Clone Git Repo

If the sample git repository hasn't been cloned yet, WDT has git tools integrated into the IDE:
1.  Open the Git repositories view
* Window -> Show View -> Other
* Type "git" in the filter box, and select "Git Repositories"
2.  Copy Git repo url by finding the textbox under " HTTPS clone URL" at the top of this page, and select "Copy to clipboard"
3.  In the Git repositories view, select the hyperlink "Clone a Git repository"
4.  The git repo url should already be filled in.  Select "Next "-> "Next" -> "Finish"
5.  The "sample.appclient.basiccalc [master]" repo should appear in the view

#### Import Maven projects into WDT

TBD

#### Create a Runtime Environment and a Liberty Server

For the purposes of this sample, we will create the Liberty server (step 3 in the wasdev.net instructions) a little differently:

1. Create a Runtime Environment in Eclipse
    1. Open the 'Runtime Explorer' view:
        * *Window -> Show View -> Other*
        * type `runtime` in the filter box to find the view (it's under the Server heading).
    2. Right-click in the view, and select *New -> Runtime Environment*
    3. Give the Runtime environment a name, e.g. `wlp-2015.6.0.0` if you're using the June 2015 beta.
    4. Either:
        * Select an existing installation (perhaps what you downloaded earlier, if you followed those instructions), or
        * select *Install from an archive or a repository* to download a new Liberty archive.
    5. Follow the prompts (and possibly choose additional features to install) until you *Finish* creating the Runtime Environment
2. Add the User directory from the maven project
    1. *Right-click -> Edit* the Runtime Environment created above
    2. Click the `Advanced Options...` link
        3. If the `basiccalc-wlpcfg` directory is not listed as a User Directory, we need to add it:
            1. Click New
            2. Select the basiccalc-wlpcfg project
            3. Select Finish, OK, Finish
        4. You should see the `basiccalc-wlpcfg` listed under the Runtime Environment in the Runtime Explorer view.
3. Create a Server to represent our application and maven configuration in Eclipse
    1. From the Runtime Explorer view, *Right-click* on the basiccalc-wlpcfg user directory associated with the target runtime, and select *New Server*.
    2. The resulting dialog should be pre-populated with the websocketSample Liberty profile server.
    3. Click Finish

#### Running application from WDT

1.  Select the "basiccalc-ear" project
2.  Right-click -> "Run As..." -> "Run On Server"
3.  Select the "WebShere Application Server under localhost" folder, and select "Finish"

TBD for running application client

## Tips

* When importing the existing maven project into Eclipse, Eclipse will (by default) "helpfully" add this project to an (extraneous) ear. To turn this off, go to Preferences -> Java EE -> Project, and uncheck "Add project to an EAR" before you import the project. If you forgot to do this, just delete the ear project; no harm.

* If you use bash, consider trying the [command line tools](https://github.com/WASdev/util.bash.completion), which provide tab-completion for the server and other commands.


## Notice

© Copyright IBM Corporation 2015.

## License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````

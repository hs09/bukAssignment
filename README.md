# bukAssignment

Application to add, get and search keys to a in memory map.

### Package
Run mvn package to create a package.

### Running the application
The application can be run locally using the Dockerfile and creating a image.
For deploying the helm chart first time, use following command:
helm install -f values.yaml bukAssignment ./k8s/bukassignment/
Once the chart is installed we can use the upgrade command to upgrade a release.

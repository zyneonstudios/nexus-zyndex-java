# Create an instance
This will show you how to create an instance in a Zyndex.

## Step 1 - Navigate to the instances folder

### 1.1: Open your management tool
Depending on how you manage your Zyndex, open either an IDE, a file explorer or whatever you want to use to modify your Zyndex.

### 1.2: Open your Zyndex folder
Open the `Zyndex` folder with your management tool/explorer.

### 1.3: Create instances folder
If it doesn't already exist, create a new folder called "instances" in the `Zyndex` folder where the `index.json` is located.

### 1.4: Open instances folder
Open the `instances` folder in your `Zyndex` folder.

## Step 2 - Create the instance json file

### 2.1: Create the instance path
> **IDs and paths depend on each other!**<br>
> The structure in the `instances` folder is determined by the instance IDs. This means that if an instance has a slash in the ID, it means that a folder must be created for each `/`.<br>
> If the instance should have the ID "example". Create a new file called “example.json” in your `instances` folder. If you want the instance ID to be "test/example", create a new folder called "test" in your `instances` folder and create the example.json in there.

Create the required folders.<br>If your ID does not contain a slash (`/`) proceed with [Step 2.2](#2-2)!

### 2.2: Create the instance json file{id="2_2"}
Navigate to your instance path (or your `instance` folder) and create a .json file for your instance. If you have a slash (`/`) in your instance ID, name the file as described in the examples above and below, otherwise name your instance "$instance_id.json".<br>

#### Examples
Instance id: example
```    
    Zyndex main folder
        ╚● instances
            ╚ example.json (new file)
```
Instance id: test/example
```    
    Zyndex main folder
        ╚● instances
            ╚● test (instance path folder)
                ╚ example.json
```

## Step 3 - Create file structure
This section explains how the instance JSON file is structured and which properties you have to define and which are optional.<br>
Please always look at the JSON file examples so that there are no difficulties.

### 3.1: Create basic JSON structure
First of all, copy the following into the file:
```
{
  "instance": {

  },
  "scheme": "2024.3"
}
```

### 3.2: Provide basic information
Add a new property to "instance" called "info" and define the following points:
- `author`¹: Define the instance creator(s)
- `description`¹: Write a short summary about the instance
- `name`¹: Enter the display name of the instance (NOT the id)
- `version`¹: Define the instance version

¹Is required

Now your JSON should look something like this:
```
#WARNING: These are example values! 

{
  "instance": {
    "info": {
      "author": "Mustermann",
      "description": "A simple modpack providing cute cats!",
      "name": "Musterpack",
      "version": "69.420.947"
    }
  },
  "scheme": "2024.3"
}
```
{collapsible="true"}

### 3.3: Provide some meta information
Add a new property to "instance" called "meta" and define the following points:
- `download`¹: An url that provides a direct .zip download of the instance
- `forgeType`²: Enter "OLD" here, if the Minecraft version you are using is below 1.12.2, if it is higher or equal enter "NEW"
- `isHidden`¹: Enter true, if you want to hide the instance, if not enter false (without quotation marks)
- `id`¹: Enter the instance id (Short reminder of the [step 2.1 note](#2-1-create-the-instance-path))
- `location`¹: Enter the address through which the instance json should be accessible.
- `origin`¹: Enter the address of your Zyndex index.json.
- `tags`³: Optionally enter an array of tags for your instance.

¹Is required<br>
²Only needed if the Forge mod loader is used.<br>
³Optional

Now your JSON should look something like this:
```
#WARNING: These are example values! 

{
  "instance": {
    "info": {
      "author": "Mustermann",
      "description": "A simple modpack providing cute cats!",
      "name": "Musterpack",
      "version": "69.420.947"
    }
    
    "meta": {
      "download": "https://link.to/instance.zip",
      "isHidden": false,
      "id": "example.json",
      "location": "https://example.com/zyndex/instances/example.json",
      "origin": "https://example.com/zyndex/index.json",
      "tags": [
        "minecraft-1.20.4",
        "modloder-fabric"
      ]
    }
    
  },
  "scheme": "2024.3"
}
```
{collapsible="true"}

### 3.4: Provide some designs (optional step)
Add a new property to "instance" called "resources" and optionally define the following points:
- `background`³: Here you can provide an url to an image for the background. (recommended aspect ratio: 16:9)
- `icon`³: Here you can provide an url to an image for the instance icon. (recommended aspect ratio: 1:1)
- `logo`³: Here you can provide an url to an image for foreground logo. (recommended aspect ratio: 16:9)
- `thumbnail`³: Here you can provide an url to an image for the search results. (recommended aspect ratio: 1:1)

³Optional

Now your JSON should look something like this:
```
#WARNING: These are example values! 

{
  "instance": {
    "info": {
      "author": "Mustermann",
      "description": "A simple modpack providing cute cats!",
      "name": "Musterpack",
      "version": "69.420.947"
    }
    "meta": {
      "download": "https://link.to/instance.zip",
      "isHidden": false,
      "id": "example.json",
      "location": "https://example.com/zyndex/instances/example.json",
      "origin": "https://example.com/zyndex/index.json",
      "tags": [
        "minecraft-1.20.4",
        "modloder-fabric"
      ]
    },
    
    "resources": {
      "background: "https://url.to/background.png"
      "icon": "https://url.to/icon.png"
      "logo": "https://url.to/logo.png"
      "thumbnail": ""https://url.to/thumbnail.png""
    }
    
  },
  "scheme": "2024.3"
}
```
{collapsible="true"}

### 3.5: Provide versions information
Add a new property to "instance" called "resources" and optionally define the following points:
- `fabric`⁴: Define the Fabric version that the instance uses
- `forge`²: Define the Forge version that the instance uses
- `minecraft`¹: Define the Minecraft version that the instance uses

¹Is required<br>
²Only needed if the Forge mod loader is used.<br>
⁴Only needed if the Fabric mod loader is used.

Now your JSON should look something like this:
```
#WARNING: These are example values! 

{
  "instance": {
    "info": {
      "author": "Mustermann",
      "description": "A simple modpack providing cute cats!",
      "name": "Musterpack",
      "version": "69.420.947"
    }
    "meta": {
      "download": "https://link.to/instance.zip",
      "isHidden": false,
      "id": "example.json",
      "location": "https://example.com/zyndex/instances/example.json",
      "origin": "https://example.com/zyndex/index.json",
      "tags": [
        "minecraft-1.20.4",
        "modloder-fabric"
      ]
    },
    "resources": {
      "background: "https://url.to/background.png"
      "icon": "https://url.to/icon.png"
      "logo": "https://url.to/logo.png"
      "thumbnail": ""https://url.to/thumbnail.png""
    },
    
    "versions": {
      "fabric": "0.15.7",
      "minecraft": "1.20.4"
    }
    
  },
  "scheme": "2024.3"
}
```
{collapsible="true"}

### 3.6: Recheck
Now check all the values in your file again.<br>
If you think all of them are correct, you're done creating your instance!

> **WARNING: These are example values!**<br>
> Your file should now look something like this:
```
{
  "instance": {
    "info": {
      "author": "Mustermann",
      "description": "A simple modpack providing cute cats!",
      "name": "Musterpack",
      "version": "69.420.947"
    }
    "meta": {
      "download": "https://link.to/instance.zip",
      "isHidden": false,
      "id": "example.json",
      "location": "https://example.com/zyndex/instances/example.json",
      "origin": "https://example.com/zyndex/index.json",
      "tags": [
        "minecraft-1.20.4",
        "modloder-fabric"
      ]
    },
    "resources": {
      "background: "https://url.to/background.png"
      "icon": "https://url.to/icon.png"
      "logo": "https://url.to/logo.png"
      "thumbnail": ""https://url.to/thumbnail.png""
    },
    "versions": {
      "fabric": "0.15.7",
      "minecraft": "1.20.4"
    }
  },
  "scheme": "2024.3"
}
```
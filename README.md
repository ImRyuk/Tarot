# Mystic Tarot

First of all, this project was majorly inspired from this [Website](http://www.tiragecarte.fr/tarot-divinatoire/tarot-marseille.html) in terms of rules, all the basics images were also picked from it. 

Most of the classes implements Serializable in order to save and export them.

## Entities Classes

### Player

#### Composition : 

A Player Object is composed of a name and an ArrayListCard wich is basically his cards collection.

### Card : 

#### Composition : 

A Card Object is made of a name, a description, an image and basically 5 long strings called "atout", "obstacle", "actionToLead", "result" and "synthesis" wich are predictions for the future in order to respect the rules from the inspired website and wich will help us to construc our prediction...

## Specific Classes

### ArrayListCard

The ArrayListCard is a customizable class built such as the Java ArrayList class in order to add our own specific methods. It is originally built for any kind of Object, but we'll use it for the Card Objects here in this project...

#### Methods 

It contains all of the classic methods such as Add, remove and get an object inside the Array, we can even get the desired object with the Get method thanks to his index or his name.

## Interface Classes 

The interface classes were made with WindowBuilder, an Eclipse Bundle available in its market. It helped me to maintain a better render of the interface project wich can be though to originally construct handmade. 
It basically look like this :  
![WindowBuilderView](https://www.eclipse.org/windowbuilder/images/wb_summary_shot.gif "WindowBuilderView, facultatif")

### CardsCollectionRender

#### Use

The CardsCollectionRender is used to view your whole Cards Collection, a scrollbar is here to scroll all of your cards, if you click on card, it will open a new tab with its content thanks to the CardProfileRender.  
Here, you can play the Mystic Tarot and view your future with the button Play, opening a new Tab.  
You can also Add a new Card, opening a new Tab and Export the player wich will save your profile with the Serialization method.

#### Specific method

SerializePlayer(): This method will save the player's profile with all of its cards in a new File created in the /files/serialization of the project. It requires a String name wich will be the name of the desired file.

### CardProfileRender

#### Use

The CardProfileRender is used to view a desired Card, you can see all of its parameters inside and modify them as you wish, it also contains an menu in wich you can save your modifications, go back to your cards collection or cancel the changings wich will reset the parameters. 

### CreatePlayerRender

#### Use

The CreatePlayerRender is used to view

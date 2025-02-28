# This is a project to learn and practice using selenium

## Element Identification best practices

### Xpath ruleset:
```xpath
//tagName[@attribute='value']

//*[@attribute='value']
//tagName
//tagName[@attribute]

//tagName[@attribute='value']/tagName2
(//tagName[@attribute='value']/tagName2)[index]

//tagName[@attribute='value'][@attribute2='value2']
//tagName[@attribute='value' or @attribute2='value2']

//tagName[text()='value']
//tagName[.='value']

//tagName[contains(@attribute,'subset-value')]
//tagName[contains(text(),'subset-value')]
//tagName[contains(.,'subset-value')]
```
### Best practices:
- stay away from using the class
- stay away from text
- do not unify element identification strategy, focus on optimizing locators then performance
- always consider business requirements
- never use what you need to assert for identifying the element
- use less element nodes
- for each node, use less attributes
- for each attribute, choose unique/static values
- Selenium relative locators can be used if an xpath is too complex.
- xpath axis can be used when a direct approach is too complex (https://www.w3schools.com/Xml/xpath_axes.asp)
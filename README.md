# polycreo-template-kotlin

## prepare

* your project (ex. `polycreo-foobar`)
* your package (ex. `org.polycreo.foobar`)

## setup

1. create GitHub repository
2. create Bintray repository
3. clone this repository
4. install polycreo/polycreo-lint-for-java
5. replace string

    ```
    $ find . -type f -not -path '*/\.*' -not -name 'README.md' | xargs sed -i '' \
            -e 's/@@your-project@@/polycreo-foobar/g; s/@@your-package@@/org.polycreo.foobar/g'
    ```

6. install gradle wrapper
7. rewrite `./README.md`
8. commit and push
9. configure CircleCI

package io.github.vitelotte.zomboid.mod;

import io.github.vitelotte.zomboid.mod.enums.Category;

import java.util.Set;

public class Mod {
    private WorkShop workShop;
    private String packageName;
    private Set<Category> categories;
    private Set<Mod> dependencies;

    private Set<Mod> incompatibles;
    private String explanations;

    public Mod(WorkShop workShop,
               String packageName,
               Set<Category> categories,
               Set<Mod> dependencies,
               Set<Mod> incompatibles,
               String explanations)
    {
        this.workShop = workShop;
        this.packageName = packageName;
        this.categories = categories;
        this.dependencies = dependencies;
        this.incompatibles = incompatibles;
        this.explanations = explanations;
    }
}
